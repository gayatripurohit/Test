package com.SAFUI.Pages;

import org.openqa.selenium.By;

import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;

public class AccountsPage {

	BasePage base;
	ReadingProperties prop;
	By add_accountBtn, acc_name, firstname, lastname, emailId, acc_descp, acc_address, alertOkbtn,alertDeletebtn, saveButton;
	
	public AccountsPage(BasePage bp)
	{
		prop = new ReadingProperties("Accounts.properties");
		base= bp;
		
		
	}
	
	public void locatorsForAddAccountPage(){
		
		add_accountBtn = prop.getObjectLocator(prop.CONFIG.getProperty("add_accountBtn"));
		acc_name  = prop.getObjectLocator(prop.CONFIG.getProperty("acc_name")); 
		firstname = prop.getObjectLocator(prop.CONFIG.getProperty("firstname")); 
		lastname = prop.getObjectLocator(prop.CONFIG.getProperty("lastname")); 
		emailId = prop.getObjectLocator(prop.CONFIG.getProperty("emailId"));
		acc_descp = prop.getObjectLocator(prop.CONFIG.getProperty("acc_descp"));
		acc_address= prop.getObjectLocator(prop.CONFIG.getProperty("acc_address"));
		
		saveButton = prop.getObjectLocator(prop.CONFIG.getProperty("saveBtn"));
	}
	
	public void clickAddAccountBtn(){
		base.click(add_accountBtn);
	}
	
	public void addnewAccount(String accname , String fname, String lname, String email, 
								String desc, String address){
		base.sendkeys(acc_name,accname );
		base.sendkeys(firstname,fname );
		base.sendkeys(lastname, lname);
		base.sendkeys(emailId, email);
		base.sendkeys(acc_descp, desc);
		base.sendkeys(acc_address, address);
	}
	
	public void clickSaveBtn(){
		base.click(saveButton);
	}
	
	
	//Alert - click on OK button after account is created / updated
	public void handleWindowAlert(){
		base.sleepMethod(3000);
		base.click(alertOkbtn);
	}
	
	//Alert - click on Yes delete it while deleting an account
	public void confirmDeleteAlert(){
		base.click(alertDeletebtn);
	}
	
	
}
