package com.SAFUI.Testscripts;

import org.testng.annotations.*;
import com.SAFUI.Pages.SettingPage;

public class EnableRuleTestScript {
	
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
	
	@Test
	public void enableRuleTestcase1(){
		
	}
}