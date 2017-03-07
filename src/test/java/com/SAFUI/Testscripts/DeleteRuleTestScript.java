package com.SAFUI.Testscripts;
import  org.testng.annotations.*;
import  com.SAFUI.Pages.SettingPage;

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
	
	@Test
	public void deleterule()
	{
		
	}

}
