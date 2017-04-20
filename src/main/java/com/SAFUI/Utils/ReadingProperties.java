package com.SAFUI.Utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadingProperties {
		
	public Properties CONFIG=null;
	public Properties ConfigCenterprop=null;
	public Properties Loginprop=null;
	public Properties Homeprop = null;
	FileInputStream objfile;
	
	String locatorProperty;
	String locatorType;
	String locatorValue;
	By locator;
	
	public ReadingProperties(String filenm)
	{
		CONFIG=new Properties();
	
		try
		{
			 objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository\\"+filenm+"");
			 CONFIG.load(objfile);
		}
		catch (Exception e) {			
			e.printStackTrace();
		 	}
	
	}
	
	public By getObjectLocator(String locatorProperty)
	{
		 locatorType = locatorProperty.split(":")[0];
		 locatorValue = locatorProperty.split(":")[1];

		 locator = null;
		switch(locatorType.toLowerCase())
		{
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;	
		
		}
		return locator;
	}	
}
