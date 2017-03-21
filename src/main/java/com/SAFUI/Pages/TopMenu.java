package com.SAFUI.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;

public class TopMenu{
	
	BasePage base;
	WebDriverWait wait;
	ReadingProperties prop;
	By settingpgbtn, searchpgbtn ,dashboardpgbtn ,userspgbtn ,acctbtn ,logoutbtn;
	
	public void locatorsForTopMenu(){}
	
	

	public TopMenu(BasePage pg){
		prop=new ReadingProperties();
		prop.loadProperty();
		base=pg;
	}
	
	public void goToSettingPage(){
		 settingpgbtn = By.linkText(prop.Homeprop.getProperty("settingpglocator"));
		 base.click(settingpgbtn);		
	}
	
	public void goToSearchPage(){
		searchpgbtn = By.linkText(prop.Homeprop.getProperty("searchpglocator"));
		base.click(searchpgbtn);
	}
	
	public void goToDashboardPage(){
		dashboardpgbtn = By.linkText(prop.Homeprop.getProperty("dashboardpglocator"));
		base.click(dashboardpgbtn);
	}

	public void goToUsersPage(){
		 userspgbtn = By.linkText(prop.Homeprop.getProperty("userspglocator"));
		 base.click(userspgbtn);
	}
	
	public void logoutBtn(){
		 acctbtn = By.xpath(prop.Homeprop.getProperty("accountlocator"));
		 logoutbtn= By.xpath(prop.Homeprop.getProperty("logoutlocator"));
		
		 base.click(acctbtn);		
		 wait.until(ExpectedConditions.elementToBeClickable(logoutbtn));
		
		 base.click(logoutbtn);
	}
}
