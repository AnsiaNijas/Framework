package testcases;

import org.testng.annotations.Test;

import ExtendReport.ExtentManager;
import UtilityRepository.GeneralUtilities;
import UtilityRepository.Screenshots;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

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
  
  @BeforeSuite
  public void createReport(final ITestContext testContext) {
      ExtentManager.createInstance().createTest(testContext.getName(), "message");
  }
  
  @AfterMethod(groups="sanity")
  public void afterMethod(ITestResult result) throws Exception 
  {
	  Screenshots takeScreenshotsobj=new Screenshots();
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  takeScreenshotsobj.captureScreenshot(driver, result.getName());
			 
	  }
  }
  @Parameters({"browser"})
  @BeforeClass(groups="sanity")
  public void beforeTest(String browser) throws Exception
  {
	  
	  testBasic();
	  driver=utilobj.browserLaunch(po.getProperty("URL"),browser);
  }

  @AfterClass(groups="sanity")
  public void afterTest()
  {
	  driver.close();
  }

}
