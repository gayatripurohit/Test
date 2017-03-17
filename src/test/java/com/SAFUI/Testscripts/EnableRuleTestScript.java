package com.SAFUI.Testscripts;

import org.testng.annotations.*;
import com.SAFUI.Pages.SettingPage;
import com.SAFUI.Utils.TestTemplate;

public class EnableRuleTestScript extends  TestTemplate{
	
	

	@BeforeClass
	public void before()
	{
		
		
	}

	@AfterClass
	public void closeBrowser()
	{
		System.out.println("in After class ");
		base.closeAllDrivers();
	}
	
	@Test
	public void enableRuleTestcase1(){
		
	}
}