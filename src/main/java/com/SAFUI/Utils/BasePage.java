package com.SAFUI.Utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;



public class BasePage {
	
	public WebDriver driver;
	protected WebDriverWait wait;
	protected ReadingProperties prop;
	
	BasePage base;

	public BasePage(){}
	
	public BasePage(BasePage pg){
		base= new BasePage();
		base=pg;
	}
	
	
	public void launchBrowser(String appurl){
		if(driver==null)
		{
			prop=new ReadingProperties("config.properties");
			
			
			if(prop.CONFIG.getProperty("browser").equalsIgnoreCase("Mozilla"))
			{
				System.setProperty(prop.CONFIG.getProperty("firefoxwebdriver"),System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(prop.CONFIG.getProperty("browser").equalsIgnoreCase("Chrome"))
			{
				System.setProperty(prop.CONFIG.getProperty("chromewebdriver"),System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(prop.CONFIG.getProperty("browser").equalsIgnoreCase("IE"))
			{
				System.setProperty(prop.CONFIG.getProperty("iewebdriver"),System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		wait = new WebDriverWait(driver, 1000);
		
		getUrl(appurl);
		sleepMethod(4000);
	}
	
	
	public void getUrl(String appurl){
		driver.get(appurl);
	}

	public void closeAllDrivers(){
		driver.quit(); 
	}
	
	public WebElement returnElement(By by)
	{
		return driver.findElement(by);
	}
	
	public void click(By by){
		try{
		driver.findElement(by).click();
		}catch(NoSuchElementException e){
			e.getMessage();
		}
	}
	
	
//	public void scrollPageDown(){
//		((JavascriptExecutor)driver).executeScript("scroll(0,600)");
//	}
	
//	public void clickAction(By by){
//		Actions act = new Actions (driver);
//		act.click(returnElement(by)).build().perform();
//		act.moveToElement(returnElement(by)).click(returnElement(by)).perform();
//	}
	
	public void sendkeys(By by,String str)
	{
		driver.findElement(by).sendKeys(str);
	}
	
	public void selecttext(By by,String str)
	{
		try{
			Select comDropbox= new Select(driver.findElement(by));
			comDropbox.selectByVisibleText(str);
			}catch(NoSuchElementException e){
				e.getMessage();
			}	
	}
	
	public String getTextOfElement(By by)
	{		
		return	driver.findElement(by).getText();	 
	}
	
	public void clearText(By by){
		try{
		driver.findElement(by).clear();
		}catch(NoSuchElementException e) {
			e.getMessage();
		}
		
	}

	public String verifyContainsText(String text)
	{				
		By element= By.xpath("//*[contains(text(),'"+text+"')]");
		return getTextOfElement(element);		 		
	}
	
	public boolean verifyContainsTextbyboolean(String text)
	{				
		By element= By.xpath("//*[contains(text(),'"+text+"')]");

		if(getTextOfElement(element) != null)
			return true;
		else
			return false;		
	}
		
	public void waitPresenceOfElementCondition(By by){
		
		wait.until(ExpectedConditions.presenceOfElementLocated(by));	
	}
	
	public void waitElementToBeClickableCondition(By by){
		
		wait.until(ExpectedConditions.elementToBeClickable(by));	
	}
	
	public void sleepMethod(long millisec){
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
