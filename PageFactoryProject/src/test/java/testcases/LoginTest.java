package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendReport.TestListener;
import UtilityRepository.ExcelReadSample;
import constants.Constants;
import elementRepository.LoginPage;
import org.testng.Assert;

public class LoginTest extends BaseClass
{
	
	LoginPage loginobj;
	ExcelReadSample excelobj;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	
  @Test(priority=1,description="Invalid username and password",enabled=true,groups="sanity")
  public void validateWithInvalidUsernameAndPassword() throws Exception 
  {
	 
	  loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  loginobj.login(ExcelReadSample.readingStringData(0, 0), ExcelReadSample.readingStringData(0, 1));
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
  }
  @Test(priority=2,description="Without adding username and password",enabled=true)
  public void validateWithoutAddingUsernameAndPassword() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clearUsernameAndPassword();
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
  }
  @Test(priority=3,description="Without adding username",enabled=true)
  public void validateWithoutAddingUsername() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.typePassword(ExcelReadSample.readingStringData(0, 1));
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
  }
  
  @Test(priority=4,description="Without adding password",enabled=true)
  public void validateWithoutAddingPassword() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clearUsernameAndPassword();
	  loginobj.typeUserName(ExcelReadSample.readingStringData(0, 1));
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
  
  }
  @Test(priority=5,description="Valid username and password",enabled=true,groups="sanity")
  public void validateWithValidUsernameAndPassword() throws Exception 
  {
	  loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clearUsernameAndPassword();
	  loginobj.login(ExcelReadSample.readingStringData(1, 0), ExcelReadSample.readingStringData(1, 1));
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getDashBoard(), Constants.dashboard);
  }
}
