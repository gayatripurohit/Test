package com.SAFUI.Testscripts;

import org.testng.Assert;
import org.testng.annotations.*;

import com.SAFUI.Utils.DataProviderClass;
import com.SAFUI.Utils.TestTemplate;

public class AddUsersTestscript extends TestTemplate {
	
	String username ;
	
	
	@BeforeMethod
	public void LoginPage()
	{
		login.validLogin();	
	}
	
	
	@Test(dataProvider="addnewuser",dataProviderClass=DataProviderClass.class)
	public void addNewUser(String firstname, String lastname, String email, String role)
	{
		username = firstname +" "+lastname;
		
		menu.goToUsersPage(); // navigate to users page
		
		users.clickAddNewUserButton();
		users.addNewUser(firstname, lastname, email, role);
		users.clickSaveUser();
		
		users.handleWindowAlert();
		Assert.assertEquals(username, base.verifyContainsText(username));
	}
	
	@AfterMethod
	public void LogoutPage()
	{
		login.logoutBtn();			
	}

}
