package com.SAFUI.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;

public class TopMenu{
	
	BasePage base;
	WebDriverWait wait;
	ReadingProperties prop;
	By configcenterpgbtn, searchpgbtn, dashboardpgbtn, userspgbtn ;
	

	public TopMenu(BasePage pg){
		prop=new ReadingProperties("Home.properties");		
		base=pg;
	}
	
	public void goToConfigCenterPage(){
		configcenterpgbtn = prop.getObjectLocator(prop.CONFIG.getProperty("configcenterpglocator"));		
		base.sleepMethod(3000);
		base.click(configcenterpgbtn);
		base.sleepMethod(3000);
	}
	
	public void goToSearchPage(){
		searchpgbtn = prop.getObjectLocator(prop.CONFIG.getProperty("searchpglocator"));
		base.sleepMethod(3000);
		base.click(searchpgbtn);
		base.sleepMethod(3000);
	}
	
	public void goToDashboardPage(){
		dashboardpgbtn = prop.getObjectLocator(prop.CONFIG.getProperty("dashboardpglocator"));
		base.sleepMethod(3000);
		base.click(dashboardpgbtn);
		base.sleepMethod(3000);
	}

	public void goToUsersPage(){
		userspgbtn = prop.getObjectLocator(prop.CONFIG.getProperty("userspglocator"));
		base.sleepMethod(3000);
		base.click(userspgbtn);
		base.sleepMethod(3000);
	}
	

}
