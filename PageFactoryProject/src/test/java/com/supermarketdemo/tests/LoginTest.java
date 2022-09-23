package com.supermarketdemo.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.supermarketdemo.constants.Constants;
import com.supermarketdemo.extendreport.TestListener;
import com.supermarketdemo.pages.LoginPage;
import com.supermarketdemo.utilities.DataProvidersUtility;
import com.supermarketdemo.utilities.ExcelUtility;

import org.testng.Assert;

public class LoginTest extends BaseClass
{
	
	LoginPage loginobj;
	ExcelUtility excelobj;
	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
	
	
  @Test(priority=1,description="Invalid username and password",dataProvider="loginData",dataProviderClass = DataProvidersUtility.class)
  public void validateWithInvalidUsernameAndPassword(String username, String password) throws Exception 
  {
	 
	  loginobj =new LoginPage(driver);
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  loginobj.login(username, password);
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
  }
  @Test(priority=2,description="Without adding username and password",enabled=true,retryAnalyzer = com.supermarketdemo.utilities.RetryAnalyzerUtility.class)
  public void validateWithoutAddingUsernameAndPassword() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelUtility();
	  loginobj.clearUsernameAndPassword();
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
  }
  @Test(priority=3,description="Without adding username",enabled=true,retryAnalyzer = com.supermarketdemo.utilities.RetryAnalyzerUtility.class)
  public void validateWithoutAddingUsername() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelUtility();
	  loginobj.typePassword(ExcelUtility.readingStringData(0, 0));
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
  }
  
  @Test(priority=4,description="Without adding password",enabled=true,retryAnalyzer = com.supermarketdemo.utilities.RetryAnalyzerUtility.class)
  public void validateWithoutAddingPassword() throws Exception 
  {
	  LoginPage loginobj =new LoginPage(driver);
	  excelobj=new ExcelUtility();
	  loginobj.clearUsernameAndPassword();
	  loginobj.typeUserName(ExcelUtility.readingStringData(0, 1));
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getErrorMessage(), Constants.expected);
  
  }
  @Test(priority=5,description="Valid username and password",enabled=true,groups= {"sanity","login"},retryAnalyzer = com.supermarketdemo.utilities.RetryAnalyzerUtility.class)
  public void validateWithValidUsernameAndPassword() throws Exception 
  {
	  loginobj =new LoginPage(driver);
	  excelobj=new ExcelUtility();
	  loginobj.clearUsernameAndPassword();
	  loginobj.typeUserName(ExcelUtility.readingStringData(1, 0));
	  loginobj.typePassword(ExcelUtility.readingStringData(1, 1));
	  loginobj.clickMethod();
	  extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
	  Assert.assertEquals(loginobj.getDashBoard(), Constants.dashboard);
  }
}
