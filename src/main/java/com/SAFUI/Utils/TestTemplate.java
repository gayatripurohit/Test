package com.SAFUI.Utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.SAFUI.Pages.*;

public class TestTemplate {

	protected ReadingProperties prop;
	
	protected LoginPage login;
	protected ConfigCenterPage configpage;
	protected TopMenu menu;
	protected BasePage base;
	protected UsersPage users;
	protected AccountsPage account;
	
	@BeforeClass
	public void BaseTest(){		
		prop=new ReadingProperties("config.properties");

		base=new BasePage();
		base.launchBrowser(prop.CONFIG.getProperty("appURL"));
		
		login = new LoginPage(base);
		configpage =new ConfigCenterPage(base);
		users = new UsersPage(base);
		account = new AccountsPage(base);
		menu =new TopMenu(base);	
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("in After class ");
		base.closeAllDrivers();
	}
	
}
