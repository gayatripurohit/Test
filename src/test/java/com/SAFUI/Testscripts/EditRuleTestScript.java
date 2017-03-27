package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;
import com.SAFUI.Utils.*;


public class EditRuleTestScript extends  TestTemplate{
	
	

	@BeforeClass
	public void before(){
		
	}

	@AfterClass
	public void closeBrowser()
	{
		System.out.println("in After class ");
		base.closeAllDrivers();
	}
	
	@Test(priority=1,dataProvider="Editruletestdata",dataProviderClass=ReadExcelFile.class)
	public void editRuleTestcase1(String rulenm,String severity,String attri, String filtercompa,String filtertriggervalue,
									String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
									String timewindow,String msgtemplate, String conditionexpr,String notifyrule ){
		String verifytext;
		
		menu.goToSettingPage();
		verifytext = setpage.verifyText(rulenm);
		
		if(verifytext!=null && verifytext.equals(rulenm)){
				setpage.clickEditRuleBtn(rulenm);
						
				setpage.enterRuleName(rulenm);
				setpage.enterSeverity(severity);
				
				setpage.addNewFilter(attri,filtercompa,filtertriggervalue);
				
				setpage.addNewCondition(aggregation, metric, conditioncompa, conditiontriggervalue, timewindow, msgtemplate);
				
				setpage.enterconditionExpression(conditionexpr);
				setpage.enterNotificationRuleMsg(notifyrule);
				
				setpage.clickOKBtn();
		}
		else
			System.out.println("Rule not found to edit"+ rulenm);	
		
		verifytext=setpage.verifyText(rulenm);
		Assert.assertEquals(rulenm, verifytext);
		
	}

}
