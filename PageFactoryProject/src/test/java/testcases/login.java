package testcases;

import org.testng.annotations.Test;

import UtilityRepository.ExcelReadSample;
import UtilityRepository.ExcelReadSample;
import UtilityRepository.GeneralUtilities;
import constants.Constants;
import elementRepository.loginpage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class login extends BaseClass//baseclass-parent and login childclass
{
	
	loginpage loginobj;
	ExcelReadSample excelobj;
	
  @Test(priority=1,description="Invalid username and password",enabled=true)
  public void validateWithInvalidUsernameAndPassword() throws Exception 
  {
	  loginobj =new loginpage(driver);
	  excelobj=new ExcelReadSample();
	   loginobj.typeUserName(excelobj.readingStringData(1, 0));
	  //loginobj.typeUserName(Constants.username);
	  loginobj.typePassword(excelobj.readingStringData(1, 1));
	    loginobj.clickMethod();
	  String actual = utilobj.alertGetText();//this is through excel
	  String  expected=excelobj.readingStringData(2, 1);//User or Password is not valid
	  utilobj.alertAccept();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=2,description="Without adding username and password",enabled=true)
  public void validateWithoutAddingUsernameAndPassword() throws Exception 
  {
	  loginpage loginobj =new loginpage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.clickMethod();
	  String actual = utilobj.alertGetText();//this is through excel
	  String  expected=excelobj.readingStringData(2, 1);
	  //utilobj.alertAccept();
	  Assert.assertEquals(actual, expected);
  }
  @Test(priority=3,description="Without adding username",enabled=true)
  public void validateWithoutAddingUsername() throws Exception 
  {
	  loginpage loginobj =new loginpage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.typePassword(excelobj.readingStringData(1, 1));
	  loginobj.clickMethod();
	  String actual = utilobj.alertGetText();//this is through excel
	  String  expected=excelobj.readingStringData(2, 1);
	  utilobj.alertAccept();
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(priority=4,description="Without adding password",enabled=true)
  public void validateWithoutAddingPassword() throws Exception 
  {
	  loginpage loginobj =new loginpage(driver);
	  excelobj=new ExcelReadSample();
	  loginobj.typeUserName(excelobj.readingStringData(1, 0));
	  loginobj.clickMethod();
	  String actual = utilobj.alertGetText();//this is through excel
	  String  expected=excelobj.readingStringData(2, 1);
	  utilobj.alertAccept();
	  Assert.assertEquals(actual, expected);
  }
  

}
