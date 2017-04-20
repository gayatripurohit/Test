package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SAFUI.Utils.DataProviderClass;
import com.SAFUI.Utils.TestTemplate;

public class AddAdvanceRuleTestScript  extends  TestTemplate{
	
	
	@BeforeMethod
	public void LoginPage()
	{
		login.validLogin();	
	}
	
	
	//advance rule with 1 operand
	@Test(dataProvider="Addadvanceruletestdata",dataProviderClass=DataProviderClass.class)
	public void AddAdvanceRule(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
								String exprmetric, String operand1,String operand2 , String aggregation,String expression,String conditioncompa,
								String conditiontriggervalue,String timewindow,String msgtemplate, String conditionexpr,String notifyrule)
	{
		System.out.println("in AddAdvanceRule()");
		menu.goToConfigCenterPage(); // go to ConfigCenter page
		
		configpage.clickAddNewRuleButton();

		configpage.enterRuleName(rulenm);
		configpage.enterSeverity(severity);
		     
		configpage.clickAddFilter();
		configpage.addNewFilter(attri,filtercompa,filtertriggervalue);
		
		configpage.clickAddCondition();
		configpage.clickAdvanceCondition();
		configpage.enterExpressionMetric(exprmetric);
		
		configpage.clickAddOperand();
		configpage.addOperand(operand1);
		configpage.addAdvanceCondition(aggregation, expression, conditioncompa, conditiontriggervalue, timewindow, msgtemplate);
		
		configpage.enterconditionExpression(conditionexpr);
		configpage.enterNotificationRuleMsg(notifyrule);
		
		configpage.clickOKBtn();
		configpage.handleWindowAlert();

		Assert.assertEquals(rulenm,base.verifyContainsText(rulenm));
	}
	
	
	@AfterMethod
	public void LogoutPage()
	{
		login.logoutBtn();			
	}
}
