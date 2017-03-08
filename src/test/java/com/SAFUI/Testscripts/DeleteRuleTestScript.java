package com.SAFUI.Testscripts;
import org.testng.Assert;
import  org.testng.annotations.*;
import  com.SAFUI.Pages.SettingPage;
import com.SAFUI.Utils.ReadExcelFile;

/**
  delete rule test script.
 */
public class DeleteRuleTestScript {
	
	SettingPage setpage;
	
	@BeforeClass
	public void before(){
		setpage=new SettingPage();
	}
	
	@AfterClass
	public void after(){
		setpage.closeAllDrivers();
	}
	
	@Test(priority=1,dataProvider="Deleteruletestdata",dataProviderClass=ReadExcelFile.class)
	public void deleterule(String rulenm)
	{
		String text,verify;
		text = setpage.verifyText(rulenm);
		
		if(text!=null && text.equals(rulenm)){
			setpage.clickDeleteRuleBtn(rulenm);	
		}
		else{
			System.out.println("Rule not found !!"+rulenm);
			}	
			
		Assert.assertFalse(setpage.verifyTextbyboolean(rulenm));
	}
	

}
