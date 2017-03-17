package com.SAFUI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;


public class LoginPage {

	BasePage base;
	ReadingProperties prop;
	
	
	By usernm ;
	By password;	
	By loginbtn;
	
	public LoginPage(BasePage pg){
			prop= new ReadingProperties();
			prop.loadProperty();
			base=pg;
	}
	
	
	
	public void locatorsForLogin(){
		 usernm = By.name(prop.Loginprop.getProperty("username"));
		 password = By.name(prop.Loginprop.getProperty("pwd"));	
		 loginbtn=By.id(prop.Loginprop.getProperty("loginbtn"));
	}
	
	public void enterLogindetails(String unm,String pwd)
	{
		
		base.clearText(usernm);
		base.clearText(password);
		
		base.sendkeys(usernm, unm);
		base.sendkeys(password, pwd);
		
		base.waitPresenceOfElementCondition(loginbtn);
		
		base.click(loginbtn);
		base.waitPresenceOfElementCondition(loginbtn);
	}
}
