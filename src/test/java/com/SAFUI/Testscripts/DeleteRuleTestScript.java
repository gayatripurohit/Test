package com.SAFUI.Testscripts;
import org.testng.Assert;
import  org.testng.annotations.*;
import com.SAFUI.Utils.*;

/**
  delete rule test script.
 */
public class DeleteRuleTestScript extends  TestTemplate {
	
	@BeforeMethod
	public void LoginPage()
	{
		login.validLogin();	
	}
	
	@Test(dataProvider="Deleteruletestdata",dataProviderClass=DataProviderClass.class)
	public void deleterule(String rulenm)
	{
		String text;    
		
		menu.goToConfigCenterPage();
		text = base.verifyContainsText(rulenm);
		
		if(text!=null && text.equalsIgnoreCase(rulenm)){
			configpage.clickDeleteRuleBtn(rulenm);	
		}
		else{
			System.out.println("Rule not found !!"+rulenm);
			}	
			
		Assert.assertFalse(base.verifyContainsTextbyboolean(rulenm));
	}
	
	@AfterMethod
	public void LogoutPage()
	{
		login.logoutBtn();	
		
	}
	
	
	@AfterClass     
	public void after(){
		base.closeAllDrivers();
	}

}
