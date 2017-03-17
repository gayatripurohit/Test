package com.SAFUI.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProperties {
		
	public Properties CONFIG=null;
	public Properties Settingprop=null;
	public Properties Loginprop=null;
	public Properties Homeprop = null;
	
	public void loadProperty()
	{
		CONFIG=new Properties();
		Settingprop =new Properties();
		Loginprop = new Properties();
		Homeprop = new Properties();
		
		try
		{
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\browser.properties");
			CONFIG.load(objfile);
			
			FileInputStream settingfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\Setting.properties");
			Settingprop.load(settingfile);
			
			FileInputStream loginfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\Login.properties");
			Loginprop.load(loginfile);
			
			FileInputStream homefile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\Home.properties");
			Homeprop.load(homefile);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		 	}
	
	}
	
}
