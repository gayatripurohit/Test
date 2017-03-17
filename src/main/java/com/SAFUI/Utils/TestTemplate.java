package com.SAFUI.Utils;

import com.SAFUI.Pages.*;

public class TestTemplate {

	protected ReadingProperties prop;
	
	protected LoginPage login;
	protected SettingPage setpage;
	protected TopMenu menu;
	protected BasePage base;
	
	public void BaseTest(){
		
		prop=new ReadingProperties();
		prop.loadProperty();

		base=new BasePage();
		base.launchBrowser(prop.Loginprop.getProperty("appURL"));
		
		login = new LoginPage(base);
		setpage =new SettingPage(base);
		menu =new TopMenu(base);
		
		
	}
	
}