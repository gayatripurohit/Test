package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;

import com.SAFUI.Utils.DataProviderClass;
import com.SAFUI.Utils.TestTemplate;

public class AddAccountsTestScript extends TestTemplate {

	@BeforeMethod
	public void LoginPage()
	{
		login.AccountLogin();	
	}
	
	
	@Test(dataProvider ="addnewaccounts" , dataProviderClass = DataProviderClass.class)
	public void addNewAccount(String acc_name , String firstname, String lastname, String admin_email, 
							  String acc_desc, String acc__holder_address){
		
		account.locatorsForAddAccountPage();	
		account.clickAddAccountBtn();
		
		account.addnewAccount(acc_name, firstname, lastname, admin_email, acc_desc, acc__holder_address);
		account.clickSaveBtn();
		
		account.handleWindowAlert();
		Assert.assertEquals(acc_name,base.verifyContainsText(acc_name));
		
	}
	
	@AfterMethod
	public void LogoutPage()
	{
		login.logoutBtn();			
	}
	
}
