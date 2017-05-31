package com.SAFUI.Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;


public class LoginPage {
	
	BasePage base;
	ReadingProperties prop;
	boolean text;
	WebElement element;
	
	By usernm ,password,loginbtn,appnm,acctbtn ,logoutbtn;
	
	public LoginPage(BasePage pg){
			prop= new ReadingProperties("Login.properties");
			
			base=pg;
			locatorsForLoginAndLogout();
	}

	public void locatorsForLoginAndLogout(){
		 usernm =	prop.getObjectLocator(prop.CONFIG.getProperty("username"));
		 password = prop.getObjectLocator(prop.CONFIG.getProperty("password"));	
		 loginbtn = prop.getObjectLocator(prop.CONFIG.getProperty("loginbtn"));
		 
		 acctbtn = prop.getObjectLocator(prop.CONFIG.getProperty("accountlocator"));
		 logoutbtn= prop.getObjectLocator(prop.CONFIG.getProperty("logoutlocator"));
	}
	
	// method used for Login in Add new rule test script 
	public void validLogin(){
		prop= new ReadingProperties("config.properties");
		
		base.sendkeys(usernm,prop.CONFIG.getProperty("unm"));
		base.sendkeys(password,prop.CONFIG.getProperty("pwd"));
		
		base.sleepMethod(3000);
		
		base.click(loginbtn);		
	}
	
	public void AccountLogin(){
		prop= new ReadingProperties("config.properties");
		
		base.sendkeys(usernm,prop.CONFIG.getProperty("username_app"));
		base.sendkeys(password,prop.CONFIG.getProperty("password_app"));
		
		base.sleepMethod(3000);
		
		base.click(loginbtn);		
	}
	
	//test case method for Login 
	public void enterLogindetails(String unm,String pwd)
	{
		base.clearText(usernm);
		base.clearText(password);
		
		base.sendkeys(usernm, unm);
		base.sendkeys(password, pwd);
		
		base.sleepMethod(3000);
		
		base.click(loginbtn);
	}
	
	
	public void logoutBtn(){	
		 base.click(acctbtn);		
		 base.waitElementToBeClickableCondition(logoutbtn);
		
		 base.click(logoutbtn);
		 
	}
	
	public boolean isElementPresent(String result){
		if (result.equalsIgnoreCase("true")){	
			appnm= prop.getObjectLocator(prop.CONFIG.getProperty("appnm"));		
			try{
				element = base.returnElement(appnm);
				return true;
			}catch(NoSuchElementException e){
				e.printStackTrace();
				return false;
			}
		}
		else if(result.equalsIgnoreCase("false")) {
			appnm= prop.getObjectLocator(prop.CONFIG.getProperty("invalidlogin"));	
			try{
				element = base.returnElement(appnm);
				return true;
			   }catch(NoSuchElementException e){
				   e.printStackTrace();
				   return false;
			   }
		}
	
	return false;	
	}
	
}
