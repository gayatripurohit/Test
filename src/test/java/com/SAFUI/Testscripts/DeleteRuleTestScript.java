package com.SAFUI.Testscripts;
import org.testng.Assert;
import  org.testng.annotations.*;
import com.SAFUI.Utils.*;

/**
  delete rule test script.
 */
public class DeleteRuleTestScript extends  TestTemplate {
	

	
	@BeforeClass
	public void before(){
		
	}
	
	@AfterClass     
	public void after(){
		base.closeAllDrivers();
	}
	
	@Test(priority=1,dataProvider="Deleteruletestdata",dataProviderClass=ReadExcelFile.class)
	public void deleterule(String rulenm)
	{
		String text;    
		
		menu.goToSettingPage();
		
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
