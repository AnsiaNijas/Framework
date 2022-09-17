package testcases;

import org.testng.annotations.Test;

import UtilityRepository.ExcelReadSample;
import UtilityRepository.GeneralUtilities;
import constants.Constants;
import elementRepository.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest extends BaseClass
{
	
	LoginPage loginobj;
	ExcelReadSample excelobj;
	
	
  @Test(priority=1,description="Invalid username and password",enabled=true,groups="sanity")
  public void validateWithInvalidUsernameAndPassword() throws Exception 
  {
	  loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.login(ExcelReadSample.readingStringData(0, 0), ExcelReadSample.readingStringData(0, 1));
	  String actual ="";
	  String  expected="";
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=2,description="Without adding username and password",enabled=true)
  public void validateWithoutAddingUsernameAndPassword() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clearUsernameAndPassword();
	  loginobj.clickMethod();
	  String actual ="";
	  String  expected="";
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=3,description="Without adding username",enabled=true)
  public void validateWithoutAddingUsername() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.typePassword(ExcelReadSample.readingStringData(0, 1));
	  loginobj.clickMethod();
	  String actual ="";
	  String  expected="";
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(priority=4,description="Without adding password",enabled=true)
  public void validateWithoutAddingPassword() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clearUsernameAndPassword();
	  loginobj.typeUserName(ExcelReadSample.readingStringData(0, 1));
	  loginobj.clickMethod();
	  String actual ="";
	  String  expected="";
	  Assert.assertEquals(actual, expected);
  
  }
  @Test(priority=5,description="Valid username and password",enabled=true,groups="sanity")
  public void validateWithValidUsernameAndPassword() throws Exception 
  {
	  loginobj =new LoginPage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clearUsernameAndPassword();
	  loginobj.login(ExcelReadSample.readingStringData(1, 0), ExcelReadSample.readingStringData(1, 1));
	  String actual ="";
	  String  expected="";
	  Assert.assertEquals(actual, expected);
  }
}
