/**
 * 
 */
package com.SAFUI.Testscripts;
import 	com.SAFUI.Pages.SettingPage;
import 	com.SAFUI.Utils.ReadExcelFile;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 */
public class AddNewRuleTestScript {
	
	SettingPage setpage;
	
	@BeforeClass
	public void before()
	{
		setpage = new SettingPage();
	}

	@AfterClass
	public void closeBrowser()
	{
		System.out.println("in After class ");
		setpage.closeAllDrivers();
	}
	
	
	@Test(priority=1,dataProvider="Addnewruletestdata",dataProviderClass=ReadExcelFile.class)
	public void AddNewRuleBtn(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
									String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
									String timewindow,String msgtemplate, String conditionexpr,String notifyrule )
	{
		String text;
		
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
				
		text =setpage.verifyText(rulenm);
		Assert.assertEquals(rulenm,text);
	}
	
	


}
