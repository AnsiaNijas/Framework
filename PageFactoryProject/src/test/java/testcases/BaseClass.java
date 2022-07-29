package testcases;

import org.testng.annotations.Test;

import UtilityRepository.GeneralUtilities;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class  BaseClass 
{
  WebDriver driver;
  GeneralUtilities utilobj=new GeneralUtilities();
  public static Properties po;
  public static void testBasic() throws Exception
  {
	   
	  
	  po = new Properties();
	  FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\Configuration.properties");
	  po.load(file);
  }
  


 
  @BeforeMethod
  public void beforeMethod() 
  {
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	 //utilobj.screenshotcommand();
  }
  @Parameters({"browser"})
  @BeforeTest
  public void beforeTest(String browser) throws Exception
  {
	  testBasic();
	  driver=utilobj.browserLaunch(po.getProperty("URL"),browser);
  }

  @AfterTest
  public void afterTest()
  {
	  //driver.close();
  }

}
