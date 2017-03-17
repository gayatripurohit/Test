package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;

import com.SAFUI.Pages.TopMenu;
import com.SAFUI.Pages.LoginPage;
import com.SAFUI.Utils.ReadExcelFile;
import com.SAFUI.Utils.ReadingProperties;
import com.SAFUI.Utils.TestTemplate;

public class LoginTestScript extends  TestTemplate{
	
	
	@BeforeSuite
	public void before()
	{
		BaseTest();
	}
	
	@AfterClass
	public void after(){
		
	}
	
	@Test(dataProvider="logindata",dataProviderClass=ReadExcelFile.class)
	public void LoginPage(String usernm, String password)
	{
		login.locatorsForLogin();
		login.enterLogindetails(usernm,password);
		//Assert.assertEquals();
		
	}
	
}
