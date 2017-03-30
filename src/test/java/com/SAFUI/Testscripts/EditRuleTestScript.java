package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;
import com.SAFUI.Utils.*;


public class EditRuleTestScript extends  TestTemplate{

	String verifytext;
	
	@BeforeMethod
	public void LoginPage()
	{
		login.validLogin();	
	}
	
	@Test(dataProvider="Editruletestdata",dataProviderClass=DataProviderClass.class)
	public void editRuleTestcase1(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
								  String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
								  String timewindow,String msgtemplate, String conditionexpr,String notifyrule ){
		
		
		menu.goToConfigCenterPage();
		verifytext = base.verifyContainsText(rulenm);
		
		if(verifytext!=null && verifytext.equals(rulenm)){
			configpage.clickEditRuleBtn(rulenm);
						
			configpage.enterRuleName(rulenm);
			configpage.enterSeverity(severity);
				
			configpage.addNewFilter(attri,filtercompa,filtertriggervalue);
				
			configpage.addNewCondition(aggregation, metric, conditioncompa, conditiontriggervalue, timewindow, msgtemplate);
				
			configpage.enterconditionExpression(conditionexpr);
			configpage.enterNotificationRuleMsg(notifyrule);
				
			configpage.clickOKBtn();
		}
		else
			System.out.println("Rule not found to edit"+ rulenm);	
		
		verifytext=base.verifyContainsText(rulenm);
		Assert.assertEquals(rulenm, verifytext);
		
	}
	
	@AfterMethod
	public void LogoutPage()
	{
		login.logoutBtn();	
		
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("in After class ");
		base.closeAllDrivers();
	}
	
}
