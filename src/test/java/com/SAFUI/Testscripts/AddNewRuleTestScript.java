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
	
	
	
	@BeforeMethod
	public void LoginPage()
	{
		login.validLogin();	
	}
	
	
	@Test(dataProvider="Addnewruletestdata",dataProviderClass=DataProviderClass.class)
	public void AddNewRuleBtn(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
									String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
									String timewindow,String msgtemplate, String conditionexpr,String notifyrule )
	{
		
		System.out.println("in AddNewRuleBtn()");
		menu.goToConfigCenterPage(); // go to ConfigCenter page
		
		configpage.clickAddNewRuleButton();
		configpage.enterRuleName(rulenm);
		configpage.enterSeverity(severity);
		     
		configpage.clickAddFilter();
		configpage.addNewFilter(attri,filtercompa,filtertriggervalue);
				
		configpage.clickAddNewCondition();
		configpage.addNewCondition(aggregation, metric, conditioncompa, conditiontriggervalue, timewindow, msgtemplate);
		

		configpage.enterconditionExpression(conditionexpr);
		configpage.enterNotificationRuleMsg(notifyrule);
		
		configpage.clickOKBtn();
		
		menu.goToSearchPage(); // as the list is not displayed after creating a rule
		menu.goToConfigCenterPage();

		Assert.assertEquals(rulenm,base.verifyContainsText(rulenm));
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
