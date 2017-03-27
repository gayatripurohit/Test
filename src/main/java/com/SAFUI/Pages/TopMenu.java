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
		prop=new ReadingProperties();
		prop.loadProperty();
		base=pg;
	}
	
	public void goToSettingPage(){
		configcenterpgbtn = prop.getObjectLocator(prop.Homeprop.getProperty("configcenterpglocator"));
		base.waitPresenceOfElementCondition(configcenterpgbtn);
		base.waitPresenceOfElementCondition(configcenterpgbtn);
		 base.click(configcenterpgbtn);		
	}
	
	public void goToSearchPage(){
		searchpgbtn = prop.getObjectLocator(prop.Homeprop.getProperty("searchpglocator"));
		base.click(searchpgbtn);
	}
	
	public void goToDashboardPage(){
		dashboardpgbtn = prop.getObjectLocator(prop.Homeprop.getProperty("dashboardpglocator"));
		base.click(dashboardpgbtn);
	}

//	public void goToUsersPage(){
//		 userspgbtn = prop.getObjectLocator(prop.Homeprop.getProperty("userspglocator"));
//		 base.click(userspgbtn);
//	}
	

}
