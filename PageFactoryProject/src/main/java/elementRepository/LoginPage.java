package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
   WebDriver driver;
   @FindBy(xpath="//input[@type='text']")
	WebElement username;
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement signIn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMsg;
	@FindBy(xpath="//li[contains(text(),'Dashboard')]")
	WebElement dashBoard;
   
   public void login(String username1, String password1)
   {
		   username.sendKeys(username1);
		   password.sendKeys(password1);
		   signIn.click();
   }
   public void typeUserName(String username1 )
   {
	   username.sendKeys(username1);
   }
   public void typePassword(String password1)
   {
	   password.sendKeys(password1);
   }
   public void clickMethod()  
   {
	   signIn.click();
   }
   public void clearUsernameAndPassword()  
   {
	  username.clear();
	  password.clear();
   }
   public String getErrorMessage()  
   {
	   return errorMsg.getText();
   }
   public String getDashBoard()  
   {
	   return dashBoard.getText();
   }
   
   
   public LoginPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
}
