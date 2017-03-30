package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;
import com.SAFUI.Utils.DataProviderClass;
import com.SAFUI.Utils.TestTemplate;

public class LoginTestScript extends  TestTemplate{

	
	@Test(dataProvider="logindata",dataProviderClass=DataProviderClass.class)
	public void LoginPage(String usernm, String password, String result)
	{
		login.enterLogindetails(usernm,password);
		
		Assert.assertTrue(login.isElementPresent(result));		
	}
	
	
	@AfterClass
	public void after(){
		System.out.println("in After class ");
		base.closeAllDrivers();
	}
	
	
}
