package com.SAFUI.Utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadingProperties {
		
	public Properties CONFIG=null;
	public Properties Settingprop=null;
	public Properties Loginprop=null;
	public Properties Homeprop = null;
		
	String locatorProperty;
	String locatorType;
	String locatorValue;
	By locator;
	
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
	
	public By getObjectLocator(String locatorProperty)
	{
		 //locatorProperty = propertyFile.getProperty(locatorName);
		 System.out.println(locatorProperty.toString());
		 locatorType = locatorProperty.split(":")[0];
		 locatorValue = locatorProperty.split(":")[1];

		 locator = null;
		switch(locatorType)
		{
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;		
		}
		return locator;
	}	
}
