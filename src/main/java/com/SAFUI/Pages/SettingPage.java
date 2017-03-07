/**
 * 
 */
package com.SAFUI.Pages;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import com.SAFUI.Utils.BasePage;
/**
 *This class contains all the locators and methods used for Setting page
 *
 */

public class SettingPage extends BasePage{
	// all locators on add new rule page
	
	WebDriverWait wait;
	
	By addnewrulebtn=By.xpath(prop.Settingprop.getProperty("addnewrulebtnlocator"));
	By ruleName = By.id(prop.Settingprop.getProperty("rulenamelocator"));
	By severity = By.name(prop.Settingprop.getProperty("severitylocator"));
	
	By addFilterBtn = By.xpath(prop.Settingprop.getProperty("addfilterbtnlocator"));
	By attriDropbox = By.name(prop.Settingprop.getProperty("attributelocator"));
	By comparatorDropbox = By.cssSelector(prop.Settingprop.getProperty("compdropboxlocator"));
	By filtertriggervalue =By.name(prop.Settingprop.getProperty("ftriggervaluelocator"));

	By addconditionBtn = By.xpath(prop.Settingprop.getProperty("addconditionbtnlocator"));
	By aggreDropboxcon = By.name(prop.Settingprop.getProperty("aggredropboxconlocator"));
	By metricDrpboxcon = By.name(prop.Settingprop.getProperty("metricDrpboxconlocator"));
	By compDropboxcon = By.cssSelector(prop.Settingprop.getProperty("compDropboxconlocator"));
	By condTrrigerValue = By.name(prop.Settingprop.getProperty("condTrrigerValuelocator"));
	By condTimeWindow = By.name(prop.Settingprop.getProperty("condTimeWindowlocator"));
	By msgTemplate = By.name(prop.Settingprop.getProperty("msgTemplatelocator"));
	
	By condExpression=By.name(prop.Settingprop.getProperty("condExpressionlocator"));
	By notiRuleMsg = By.name(prop.Settingprop.getProperty("notiRuleMsglocator"));
			
	By okBtn = By.cssSelector(prop.Settingprop.getProperty("okBtnlocator"));
	
	

	// locators for enable, delete rule on setting page
	By enablebtn= By.xpath("//h3[text()='BANDWIDTH Rule']/parent::div/following::div[1]/div/button[text()='Enable']");
	By deletebtn;
	
	
	public SettingPage()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.CONFIG.getProperty("appURL"));
		wait = new WebDriverWait(driver, 5);
		
	}
	
	
//	public void selectOptionWithText(String textToSelect) {
//		try {
//			WebElement autoOptions = driver.findElement(By.xpath("//a[contains(text(),'wlc_client_data')]"));
//			autoOptions.click();		
//			System.out.println("AutoOptions : "+ autoOptions.getText());
//			wait.until(ExpectedConditions.visibilityOf(autoOptions));
//
//			List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath(".//*[contains(@id,'typeahead-')]/a"));
//			System.out.println("Options list: "+ optionsToSelect.containsAll(optionsToSelect));
//			for(WebElement option : optionsToSelect){
//		        if(option.getText().equals(textToSelect)) {
//		        	System.out.println("Trying to select: "+textToSelect);
//		            option.click();
//		            break;
//		        }
//		    }
//			
//		} catch (NoSuchElementException e) {
//			System.out.println(e.getStackTrace());
//		}
//		catch (Exception e) {
//			System.out.println(e.getStackTrace());
//		}
//	}
	   
	
	public void clickAddNewRuleButton()
	{
		click(addnewrulebtn); 
	}
	
	public void enterRuleName(String rulenm)
	{ 
		sendkeys(ruleName,rulenm);
	}
	
	public void enterSeverity(String serty)
	{
		selecttext(severity, serty);
	}
	
	public void clickAddFilter()
	{
		click(addFilterBtn);
	}

	
	public void addNewFilter(String attri, String filtercompa,String ftriggervalue)
	{
		selecttext(attriDropbox, attri);
		selecttext(comparatorDropbox, filtercompa);
		
		WebElement ftv=returnElement(filtertriggervalue);
		ftv.sendKeys(Keys.TAB);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filtertriggervalue));
		
		sendkeys(filtertriggervalue,ftriggervalue);
		try{
		WebElement autoOptions = driver.findElement(By.xpath("//a[contains(text(),'"+ftriggervalue+"')]"));
		autoOptions.click();
		
		}catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	
	public void clickAddNewCondition()
	{
		click(addconditionBtn);
	}
	
	public void addNewCondition(String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
			String timewindow,String msgtemplate)
	{
		selecttext(aggreDropboxcon, aggregation);
	
		selecttext(metricDrpboxcon, metric);
	
		selecttext(compDropboxcon, conditioncompa);
		
		
		sendkeys(condTrrigerValue,conditiontriggervalue);
		sendkeys(condTimeWindow,timewindow);
		sendkeys(msgTemplate,msgtemplate);
	}
 
	public void enterconditionExpression(String conditionexpr)
	{
		sendkeys(condExpression,conditionexpr);
	}
	
	public void enterNotificationRuleMsg(String notifyrule)
	{
		sendkeys(notiRuleMsg,notifyrule);
	}
	
	public void clickOKBtn()
	{
		click(okBtn);
	}
	
	public boolean verifyRuleNm(String rulenm)
	{
		By verifyrulenm= By.xpath("//*[contains(text(),'"+rulenm+"')]");
		
		boolean textfound=false;
		try
		{
			verifyRuleNameText(verifyrulenm);
			textfound=true;
		}
		catch (Exception e){
			textfound=false;
		}
		return textfound;
		
	}
	
	
	public void clickdeleteRuleBtn(String rulenm)
	{
		
		try{
			deletebtn = By.xpath("//h3[text()='"+rulenm+"']/parent::div/following::div[1]/div/button[text()='Delete']");
			if(deletebtn.toString()!=null){
				click(deletebtn);
			}else
				System.out.println("Rule not found !!!  "+rulenm);
				
		}
		catch(Exception e){
			e.getMessage();
		}
		System.out.println("Delete to string : " + deletebtn.toString());
	}
	
}
