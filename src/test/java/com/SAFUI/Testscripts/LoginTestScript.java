package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;
import com.SAFUI.Utils.ReadExcelFile;
import com.SAFUI.Utils.TestTemplate;

public class LoginTestScript extends  TestTemplate{
	
	String text;
	
	@AfterClass
	public void after(){
		System.out.println("in After class ");
		base.closeAllDrivers();
	}

	
	@Test(dataProvider="logindata",dataProviderClass=ReadExcelFile.class)
	public void LoginPage(String usernm, String password, String result)
	{
		login.enterLogindetails(usernm,password);
		
		Assert.assertTrue(login.isElementPresent(result));		
	}
	
	
	
	
}
