package com.SAFUI.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProperties {
		
	public	Properties CONFIG=null;
	public Properties Settingprop=null;
	public void loadProperty()
	{
		CONFIG=new Properties();
		Settingprop =new Properties();
		try
		{
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\browser.properties");
			CONFIG.load(objfile);
			
			FileInputStream settingfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\Setting.properties");
			Settingprop.load(settingfile);
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		 	}
	
	}
	
}
