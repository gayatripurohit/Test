package com.SAFUI.Utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public WebDriver driver;
	protected ReadingProperties prop;
	
	File file;
	FileInputStream inputStream;
	public XSSFWorkbook workbook ;
	public XSSFSheet sheet;
	
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
	
	
	public void closeAllDrivers(){
		driver.quit();
	}
	
	public WebElement returnElement(By by)
	{
		return driver.findElement(by);
	}
	
	public void click(By by){
		driver.findElement(by).click();
	}
	
	public void sendkeys(By by,String str)
	{
		driver.findElement(by).sendKeys(str);
	}
	
	public void selecttext(By by,String str)
	{
		Select comDropbox= new Select(driver.findElement(by));
		comDropbox.selectByVisibleText(str);	
	}
	
	public String verifyRuleNameText(By by)
	{
		return driver.findElement(by).getText();	
	}
	
	public void clearText(By by){
		driver.findElement(by).clear();
	}
	
	
}
