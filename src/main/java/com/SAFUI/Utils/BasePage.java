package com.SAFUI.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SAFUI.Pages.TopMenu;

public class BasePage extends By {
	
	public WebDriver driver;
	protected WebDriverWait wait;
	protected ReadingProperties prop;
	
	File file;
	FileInputStream inputStream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	BasePage base;
	
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
		wait = new WebDriverWait(driver, 50);
	}
	
	public void waitPresenceOfElementCondition(By by){
		
		wait.until(ExpectedConditions.presenceOfElementLocated(by));	
	}
	
	public void waitElementToBeCliclableCondition(By by){
		
		wait.until(ExpectedConditions.elementToBeClickable(by));	
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
		try{
		driver.findElement(by).clear();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void locator (){
		
	}
}
