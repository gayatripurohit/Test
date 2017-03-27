/**
 * 
 */
package com.SAFUI.Testscripts;
import 	com.SAFUI.Utils.*;
import  org.testng.Assert;
import  org.testng.annotations.*;

/**
 */
public class AddNewRuleTestScript extends  TestTemplate{
	
	String text;


//	@AfterClass
//	public void closeBrowser()
//	{
//		System.out.println("in After class ");
//		base.closeAllDrivers();
//	}
//	
	@BeforeMethod
	public void LoginPage()
	{
		login.validLogin();	
		menu.goToSettingPage();
	}
//	
//	@AfterMethod
//	public void LogoutPage()
//	{
//		login.logoutBtn();	
//		
//	}
	
	@Test(dataProvider="Addnewruletestdata",dataProviderClass=ReadExcelFile.class)
	public void AddNewRuleBtn(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
									String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
									String timewindow,String msgtemplate, String conditionexpr,String notifyrule )
	{
		
		System.out.println("in AddNewRuleBtn()");

		setpage.clickAddNewRuleButton();
		setpage.enterRuleName(rulenm);
		setpage.enterSeverity(severity);
		     
		setpage.clickAddFilter();
		setpage.addNewFilter(attri,filtercompa,filtertriggervalue);
				
		setpage.clickAddNewCondition();
		setpage.addNewCondition(aggregation, metric, conditioncompa, conditiontriggervalue, timewindow, msgtemplate);
		
		setpage.enterconditionExpression(conditionexpr);
		setpage.enterNotificationRuleMsg(notifyrule);
		
		setpage.clickOKBtn();
		
		//click on Config page to set focus
		
		text =setpage.verifyText(rulenm);
		Assert.assertEquals(rulenm,text);
	}
}
