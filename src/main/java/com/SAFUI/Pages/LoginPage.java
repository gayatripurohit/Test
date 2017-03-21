package com.SAFUI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;


public class LoginPage {

	BasePage base;
	ReadingProperties prop;
	boolean text;
	
	By usernm ;
	By password;	
	By loginbtn;
	By appnm;
	
	public LoginPage(BasePage pg){
			prop= new ReadingProperties();
			prop.loadProperty();
			base=pg;
			locatorsForLogin();
	}

	public void locatorsForLogin(){
		 usernm =	prop.getObjectLocator(prop.Loginprop.getProperty("username"));
		 password = prop.getObjectLocator(prop.Loginprop.getProperty("password"));	
		 loginbtn = prop.getObjectLocator(prop.Loginprop.getProperty("loginbtn"));
	}
	
	
	public void validLogin(){
		base.sendkeys(usernm,prop.Loginprop.getProperty("unm"));
		base.sendkeys(password,prop.Loginprop.getProperty("pwd"));
		
		base.waitPresenceOfElementCondition(loginbtn);
		
		base.click(loginbtn);
		
	}
	
	//test case method
	public void enterLogindetails(String unm,String pwd)
	{
		
		base.clearText(usernm);
		base.clearText(password);
		
		base.sendkeys(usernm, unm);
		base.sendkeys(password, pwd);
		
		base.waitPresenceOfElementCondition(loginbtn);
		
		base.click(loginbtn);
	}
	
	public boolean isElementPresent(){
		appnm= prop.getObjectLocator(prop.Loginprop.getProperty("appnm"));		
		text=base.verifyLogin(appnm);		
		return text;
	}
	
}
