package com.SAFUI.Utils;

import org.testng.annotations.DataProvider;
import com.SAFUI.Utils.ReadExcelFile;;


public class DataProviderClass {

	protected ReadingProperties properties;
	protected ReadExcelFile readexcel;
	
	public  Object[][] obj;	
	String 	sheet1 = "Add basic rules";
	String 	sheet2 = "Delete Rule";
	String  sheet3 = "Edit Rule";
	String  sheet4 = "Enable/Disable Rule";
	String  sheet5 = "Login Credentials";
	String  sheet6 = "Add Advance rules";
	String  sheet7 = "Advance rule with 2 operands";
	
	String sheet8 = "Add Users";
	String sheet9 = "Add Accounts";
	String  filenm;
	
	
	public DataProviderClass(){
		readexcel= new ReadExcelFile();
		properties =new ReadingProperties("ConfigCenter.properties");
		filenm=properties.CONFIG.getProperty("excelfilename");		
	}
	
	@DataProvider(name="logindata")
	public Object[][] getLoginDetails(){
		obj = readexcel.readExcelSheet( filenm, sheet5);	
		return obj;
	}
	

	@DataProvider (name = "Addbasicruletestdata")
	public Object[][] getAddBasicRuleTestData(){
		obj = readexcel.readExcelSheet (filenm,sheet1);
		return obj;
	}
	
	@DataProvider (name = "Addadvanceruletestdata")
	public Object[][] getAddAdvanceRuleTestData(){
		obj = readexcel.readExcelSheet (filenm,sheet6);
		return obj;
	}
	
	@DataProvider (name = "Addadvancerule2operands")
	public Object[][] getAddAdvanceRule2operandsTestData(){
		obj = readexcel.readExcelSheet (filenm,sheet7);
		return obj;
	}

	
	
	@DataProvider(name="Deleteruletestdata")
	public Object[][] getDeleteRuleTestData(){
		obj = readexcel.readExcelSheet( filenm, sheet2);	
		return obj;
	}
	
	
	@DataProvider(name="Editruletestdata")
	public Object[][] getEditRuleTestData(){
		obj=readexcel.readExcelSheet( filenm, sheet3);	
		return obj;
	}	

	@DataProvider(name="addnewuser")
	public Object[][] getAddUserTestData(){
		obj=readexcel.readExcelSheet( filenm, sheet8);	
		return obj;
	}	

	@DataProvider(name="addnewaccounts")
	public Object[][] getAddAccountTestData(){
		obj=readexcel.readExcelSheet( filenm, sheet9);	
		return obj;
	}	

}
