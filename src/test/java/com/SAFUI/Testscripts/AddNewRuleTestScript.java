/**
 * 
 */
package com.SAFUI.Testscripts;
import com.SAFUI.Pages.TopMenu;
import 	com.SAFUI.Utils.*;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 */
public class AddNewRuleTestScript extends  TestTemplate{
	
	String text;
	
	
	@BeforeClass
	public void before()
	{
	}

	@AfterClass
	public void closeBrowser()
	{
		System.out.println("in After class ");
		base.closeAllDrivers();
	}
	
	@Test(priority=1,dataProvider="logindata",dataProviderClass=ReadExcelFile.class)
	public void LoginPage(String usernm, String password)
	{
		login.locatorsForLogin();
		login.enterLogindetails(usernm,password);
		Assert.assertTrue(login.isElementPresent());		
	}
	
	@Test(priority=2,dataProvider="Addnewruletestdata",dataProviderClass=ReadExcelFile.class)
	public void AddNewRuleBtn(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
									String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
									String timewindow,String msgtemplate, String conditionexpr,String notifyrule )
	{
		
		System.out.println("in AddNewRuleBtn()");

		menu.goToSettingPage();
		
		setpage.locatorsForSetting();
		
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
				
		text =setpage.verifyText(rulenm);
		Assert.assertEquals(rulenm,text);
	}
	
	


}
