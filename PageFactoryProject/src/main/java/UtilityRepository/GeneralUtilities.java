package UtilityRepository;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities 
{
	WebDriver driver;
    public WebDriver browserLaunch(String url,String browserName)//browser launch method is active now
    {
    	/*switch(browserName)
    	{
    	   case "edge":
    		   WebDriverManager.edgedriver().setup();
    		   driver=new EdgeDriver();
    		   
    		   
    		   
    		   break;
    	   case  "chrome":
    		   WebDriverManager.chromedriver().setup();
    		   driver=new ChromeDriver();
    		   break;
    	   default:
    		   break;
    		   }
    		        */
    		         
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
    
    public void alertAccept()
    {
    	Alert objectalert =driver.switchTo().alert();
    	objectalert.accept();
    }
    public String alertGetText()
    {
    	Alert objectalert=driver.switchTo().alert();
    	String alertText=objectalert.getText();
    	return(alertText);
    }
    public void utilityclickcommand(By property)
    {
    	driver.findElement(property).click();
    }
    public void utilitysendKeyscommand(By property,String text)
    {
    	driver.findElement(property).sendKeys(text);
    }
    public void utilityclearcommand(By property)
    {
    	driver.findElement(property).clear();
    }
    public void screenshotcommand() throws IOException
    {
    	  Date d=new Date();
		  String date=d.toString().replace(":","_").replace(" ","_")+".png";
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source =ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source,new File("./Screenshots/"+"screenshot"+ date)); 
	      System.out.println("Screenshot Taken");
    }
    }


    

