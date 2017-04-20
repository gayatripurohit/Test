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

}
