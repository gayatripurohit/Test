package com.SAFUI.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;



public class BasePage {
	
	public WebDriver driver;
	protected WebDriverWait wait;
	protected ReadingProperties prop;
	
	File file;
	FileInputStream inputStream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	BasePage base;
	String text;
	
	
	public BasePage()
	{
		if(driver==null)
		{
			prop=new ReadingProperties();
			prop.loadProperty();
	
		
		if(prop.CONFIG.getProperty("browser").equals("Mozilla"))
		{
			System.setProperty(prop.CONFIG.getProperty("firefoxwebdriver"),System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(prop.CONFIG.getProperty("browser").equals("Chrome"))
		{
			System.setProperty(prop.CONFIG.getProperty("chromewebdriver"),System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.CONFIG.getProperty("browser").equals("IE"))
		{
			System.setProperty(prop.CONFIG.getProperty("iewebdriver"),System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}

		}
}
	
	public BasePage(BasePage pg){
		base= new BasePage();
		base=pg;
	}
	
	
	public void launchBrowser(String appurl){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(appurl);
		wait = new WebDriverWait(driver, 1000);
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
	
	public void submit(By by){
		try{
		driver.findElement(by).click();
		}catch(NoSuchElementException e){
			e.getMessage();
		}
	}
	
	public void scrollPageDown(){
		((JavascriptExecutor)driver).executeScript("scroll(0,600)");
	}
	
	public void setFocusonWindow(By by){
		Actions act = new Actions (driver);
		act.moveToElement(returnElement(by)).click().perform();
	}
	
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
	
	public String verifyText(By by)
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

	public boolean verifyLogin(By by){
	try{
		driver.findElement(by);
		return true;
		}catch(NoSuchElementException e){
			e.getMessage();
			return false ;
		}
	}
		
	public void waitPresenceOfElementCondition(By by){
		
		wait.until(ExpectedConditions.presenceOfElementLocated(by));	
	}
	
	public void waitElementToBeClickableCondition(By by){
		
		wait.until(ExpectedConditions.elementToBeClickable(by));	
	}
	

}
