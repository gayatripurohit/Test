package com.SAFUI.Pages;

import org.openqa.selenium.By;

import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;


public class LoginPage {

	BasePage base;
	ReadingProperties prop;
	boolean text;
	
	By usernm ,password,loginbtn,appnm,acctbtn ,logoutbtn;
	
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
	
	// method used for Login to Add new rule 
	public void validLogin(){
		base.sendkeys(usernm,prop.CONFIG.getProperty("unm"));
		base.sendkeys(password,prop.CONFIG.getProperty("pwd"));
		
		base.waitPresenceOfElementCondition(loginbtn);
		
		base.click(loginbtn);		
	}
	
	
	public void logoutBtn(){
		 acctbtn = prop.getObjectLocator(prop.Homeprop.getProperty("accountlocator"));
		 logoutbtn= prop.getObjectLocator(prop.Homeprop.getProperty("logoutlocator"));
		
		 base.click(acctbtn);		
		 base.waitElementToBeClickableCondition(logoutbtn);
		
		 base.click(logoutbtn);
		 
	}
	
	
	//test case method for Login 
	public void enterLogindetails(String unm,String pwd)
	{
		base.clearText(usernm);
		base.clearText(password);
		
		base.sendkeys(usernm, unm);
		base.sendkeys(password, pwd);
		
		base.waitPresenceOfElementCondition(loginbtn);
		
		base.click(loginbtn);
	}
	
	public boolean isElementPresent(String result){
		if (result.equalsIgnoreCase("true")){	
			appnm= prop.getObjectLocator(prop.Loginprop.getProperty("appnm"));		
			text=base.verifyLogin(appnm);
		}
		else if(result.equalsIgnoreCase("false")) {
			appnm= prop.getObjectLocator(prop.Loginprop.getProperty("invalidlogin"));	
			text=base.verifyLogin(appnm);
		}
		return text;
	}
	
}
