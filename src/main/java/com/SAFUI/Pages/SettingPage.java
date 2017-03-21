/**
 * 
 */
package com.SAFUI.Pages;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import com.SAFUI.Utils.BasePage;
import com.SAFUI.Utils.ReadingProperties;
/**
 *This class contains all the locators and methods used for Setting page
 *
 */

public class SettingPage {
	
	// locators for enable, delete ,edit buttons on setting page
	By enablebtn;
	By deletebtn;
	By editbtn;
	WebElement ftv;
	BasePage base;
	ReadingProperties prop;
	WebDriverWait wait;
	
	//locators for add new rule dialog
	By addnewrulebtn, ruleName, severity,addFilterBtn, attriDropbox, comparatorDropbox, filtertriggervalue, addconditionBtn,
	aggreDropboxcon ,metricDrpboxcon,compDropboxcon , condTrrigerValue ,condTimeWindow , msgTemplate ,
	condExpression,notiRuleMsg , okBtn ;
	

	
	public SettingPage(BasePage pg){	
		prop=new ReadingProperties();
		prop.loadProperty();
		base=pg;
	}
	

	public void locatorsForSetting(){
	// all locators on add new rule page
		 addnewrulebtn=By.xpath(prop.Settingprop.getProperty("addnewrulebtnlocator"));
		 ruleName = By.id(prop.Settingprop.getProperty("rulenamelocator"));
		 severity = By.name(prop.Settingprop.getProperty("severitylocator"));
		
		 addFilterBtn = By.xpath(prop.Settingprop.getProperty("addfilterbtnlocator"));
		 attriDropbox = By.name(prop.Settingprop.getProperty("attributelocator"));
		 comparatorDropbox = By.cssSelector(prop.Settingprop.getProperty("compdropboxlocator"));
		 filtertriggervalue =By.name(prop.Settingprop.getProperty("ftriggervaluelocator"));
	
		 addconditionBtn = By.xpath(prop.Settingprop.getProperty("addconditionbtnlocator"));
		 aggreDropboxcon = By.name(prop.Settingprop.getProperty("aggredropboxconlocator"));
		 metricDrpboxcon = By.name(prop.Settingprop.getProperty("metricDrpboxconlocator"));
		 compDropboxcon = By.cssSelector(prop.Settingprop.getProperty("compDropboxconlocator"));
		 condTrrigerValue = By.name(prop.Settingprop.getProperty("condTrrigerValuelocator"));
		 condTimeWindow = By.name(prop.Settingprop.getProperty("condTimeWindowlocator"));
		 msgTemplate = By.name(prop.Settingprop.getProperty("msgTemplatelocator"));
		
		 condExpression=By.name(prop.Settingprop.getProperty("condExpressionlocator"));
		 notiRuleMsg = By.name(prop.Settingprop.getProperty("notiRuleMsglocator"));
				
		 okBtn = By.cssSelector(prop.Settingprop.getProperty("okBtnlocator"));
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
		base.click(addnewrulebtn); 
	}
	
	public void enterRuleName(String rulenm)
	{ 
		base.sendkeys(ruleName,rulenm);
	}
	
	public void enterSeverity(String serty)
	{
		base.selecttext(severity, serty);
	}
	
	public void clickAddFilter()
	{
		base.click(addFilterBtn);
	}

	
	public void addNewFilter(String attri, String filtercompa,String ftriggervalue)
	{
		
		base.selecttext(attriDropbox, attri);
		base.selecttext(comparatorDropbox, filtercompa);
		
		WebElement ftv=base.returnElement(filtertriggervalue);
		base.waitElementToBeClickableCondition(filtertriggervalue);
		
		ftv.sendKeys(Keys.TAB);	
		base.waitElementToBeClickableCondition(filtertriggervalue);
		
		
		if (ftriggervalue != "Timestamp" || ftriggervalue != "SLOT" || ftriggervalue != "PORT" || 
			ftriggervalue != "APSLOTS" ||ftriggervalue != "BANDWIDTH" || ftriggervalue != "CLIENTCOUNT" ||ftriggervalue != "WLAN")
		{
				try{
				WebElement autoOptions = base.driver.findElement(By.xpath("//a[contains(text(),'"+ftriggervalue+"')]"));
				base.waitElementToBeClickableCondition(filtertriggervalue);
				List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//a[contains(text(),'"+ftriggervalue+"')][1]"));
				base.waitElementToBeClickableCondition(filtertriggervalue);
				
				System.out.println("Options list: "+ optionsToSelect.containsAll(optionsToSelect));
			
				
				for(WebElement option : optionsToSelect){
			        if(option.getText().equals(ftriggervalue)) {
			        	System.out.println("Trying to select: "+ftriggervalue);
			            option.click();
			            break;
			        }
				}
				base.waitElementToBeClickableCondition(filtertriggervalue);
				
				}catch (NoSuchElementException e) {
					System.out.println(e.getStackTrace());
				}
				catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
		}else
		{
			base.sendkeys(filtertriggervalue, ftriggervalue);
		}
		
	}
	
	
	public void clickAddNewCondition()
	{
		base.click(addconditionBtn);
	}
	
	public void addNewCondition(String aggregation,String metric,String conditioncompa,String conditiontriggervalue,
			String timewindow,String msgtemplate)
	{
		base.selecttext(aggreDropboxcon, aggregation);
		base.selecttext(metricDrpboxcon, metric);
		base.selecttext(compDropboxcon, conditioncompa);

		base.sendkeys(condTrrigerValue,conditiontriggervalue);
		base.sendkeys(condTimeWindow,timewindow);
		base.sendkeys(msgTemplate,msgtemplate);
	}
 
	public void enterconditionExpression(String conditionexpr)
	{
		base.sendkeys(condExpression,conditionexpr);
	}
	
	public void enterNotificationRuleMsg(String notifyrule)
	{
		base.sendkeys(notiRuleMsg,notifyrule);
	}
	
	public void clickOKBtn()
	{
		base.click(okBtn);
		base.waitElementToBeClickableCondition(addnewrulebtn);
	}
	
	public String verifyText(String text)
	{				
	//	xpath  //h3[contains(text()='"+text+"')]
		
		By element= By.xpath("//*[contains(text(),'"+text+"')]");
		String verifystr=base.verifyText(element);
		return verifystr;		
	}
	
	public boolean verifyTextbyboolean(String text)
	{				
	//	xpath  //h3[contains(text()='"+text+"')]
		boolean value;
		By element= By.xpath("//*[contains(text(),'"+text+"')]");
		String verifystr=base.verifyText(element);
		
		if(verifystr != null)
			value=true;
		else
			value=false;
		return value;		
	}
	
	//Delete rule button 
	public void clickDeleteRuleBtn(String rulenm)
	{
		try{
			deletebtn = By.xpath("//h3[text()='"+rulenm+"']/parent::div/following::div[1]/div/button[text()='Delete']");
			if(deletebtn.toString()!=null){
				base.click(deletebtn);
			}else
				System.out.println("Rule not found !!!  "+rulenm);
				
		}
		catch(Exception e){
			e.getMessage();
		}
		System.out.println("Delete to string : " + deletebtn.toString());
	}
	
	
	//Edit rule button 
	public void clickEditRuleBtn(String rulenm)
	{
		try{
			editbtn=By.xpath(".//h3[text()='"+rulenm+"']/parent::div/following::div[1]/div/button[1]");
			if(editbtn.toString()!=null){
				base.click(editbtn);
				base.clearText(ruleName);
				
				ftv =base.returnElement(filtertriggervalue);
				
				ftv.sendKeys(Keys.chord(Keys.CONTROL)+"a");
				ftv.sendKeys(Keys.BACK_SPACE);
				ftv.sendKeys(Keys.TAB);
				
				base.clearText(filtertriggervalue);
				base.clearText(condTrrigerValue);
				base.clearText(condTimeWindow);
				base.clearText(msgTemplate);
				base.clearText(condExpression);
				base.clearText(notiRuleMsg);
				
			}else
				System.out.println("Rule not found !!!!"+rulenm);
			
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	
}
