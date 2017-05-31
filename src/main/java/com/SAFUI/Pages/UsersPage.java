package com.SAFUI.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;

/*
 * This class contains all the locators and methods used for UsersPage page
 * */
 


public class UsersPage {
	
	BasePage base; 
	ReadingProperties prop;
	WebDriverWait wait;
	
	By addnewuserBtn, firstname, lastname, email, role,saveBtn, edituser, deleteuserBtn, alertOkbtn, alertDeletebtn;
	
	
	
	public UsersPage(BasePage bp){
		prop= new ReadingProperties("Users.properties");
		
		base=bp;
		locatorsForUsers();
		
	}
	
	public void locatorsForUsers(){
		
		addnewuserBtn 	=prop.getObjectLocator(prop.CONFIG.getProperty("adduserbtn")) ;
		firstname   	=prop.getObjectLocator(prop.CONFIG.getProperty("fname"));
		lastname    	=prop.getObjectLocator(prop.CONFIG.getProperty("lname"));
		email        	=prop.getObjectLocator(prop.CONFIG.getProperty("email"));
		role        	=prop.getObjectLocator(prop.CONFIG.getProperty("role"));
		saveBtn      	=prop.getObjectLocator(prop.CONFIG.getProperty("saveBtn"));
		
		//edituser 	    =prop.getObjectLocator(prop.CONFIG.getProperty(""));
		//deleteuserBtn   =prop.getObjectLocator(prop.CONFIG.getProperty(""));
		
		alertOkbtn = prop.getObjectLocator(prop.CONFIG.getProperty("alertOklocator"));
		alertDeletebtn = prop.getObjectLocator(prop.CONFIG.getProperty("alertYesDeletelocator"));
	}
	
	public void clickAddNewUserButton(){
		base.click(addnewuserBtn);
		base.sleepMethod(3000);
		
	}
	
	public void addNewUser(String fname, String lname, String mailid, String rolename){
		base.sendkeys(firstname, fname);
		base.sendkeys(lastname, lname);
		base.sendkeys(email, mailid);
		base.selecttext(role, rolename);	
	}
	
	public void clickSaveUser(){
		base.click(saveBtn);
	}
	
	//Alert - click on OK button after user is created / updated
	public void handleWindowAlert(){
		base.sleepMethod(3000);
		base.click(alertOkbtn);
	}
	
	//Alert - click on Yes delete it while deleting a user.
	public void confirmDeleteAlert(){
		base.click(alertDeletebtn);
	}
	
	
}
