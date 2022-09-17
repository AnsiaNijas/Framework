package UtilityRepository;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities 
{
	WebDriver driver;
    public WebDriver browserLaunch(String url,String browserName)
    {
    	   		         
    		  if(browserName.equalsIgnoreCase("edge")) 
    			  
    		  {
    			  WebDriverManager.edgedriver().setup();
    	         driver=new EdgeDriver();
    		  }
    		  
    		  else if(browserName.equalsIgnoreCase("chrome"))
    		  {
    			  WebDriverManager.chromedriver().setup();
    			  driver=new ChromeDriver();
    		  }
    	
    		  
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get(url);
    	return driver;
    	                
    }
    
    
  
    
    public void clickcommand(WebElement element)
    {
    	element.click();
    }
    public void sendKeyscommand(WebElement element,String text)
    {
    	element.sendKeys(text);
    }
    public void clearcommand(WebElement element)
    {
    	element.clear();
    }
    public String getElementText(WebElement element) {
		String text =element.getText() ;
		return text;
	}


	public void actionsOperations(WebElement element, WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.moveToElement(element).perform();
	}

	public String backgroundColor(WebElement element, String font) {
		return element.getCssValue(font);

	}

	public String alertBoxText(WebDriver driver) {
		return driver.switchTo().alert().getText();

	}

	public void accepingAlertBox(WebDriver driver) {
		driver.switchTo().alert().accept();

	}
	public void dismissingAlertBox(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public String getAttributeValue(WebElement element, String type) {

		return element.getAttribute(type);
	}

	public boolean isSlelectedVerifycheckbox(WebElement element) {

		return element.isSelected();
	}

	public String getTitle(WebDriver driver) {

		return driver.getTitle();
	}

	public String getUrl(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public void enterKeyPress(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.ENTER).perform();

	}
	
	public void javaScriptExecutorScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50000)");
	}

	public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public String dropDown(WebElement element, int i) {
		Select obj = new Select(element);
		obj.selectByIndex(i);
		WebElement a = obj.getFirstSelectedOption();
		return a.getText();
	}


	public String todaysDate() {
		DateFormat format = new SimpleDateFormat("dd/mm/yy");
		Date today = new Date();
		String completeDate = format.format(today);
		return completeDate.substring(0, 2);

	}
    }


    

