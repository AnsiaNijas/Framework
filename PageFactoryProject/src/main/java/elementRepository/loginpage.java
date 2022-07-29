package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
   WebDriver driver;
   @FindBy(xpath="//input[@name='uid']")
   WebElement userName;
   
   @FindBy(xpath="//input[@name='password']")
   WebElement password;
   
   @FindBy(xpath="//input[@name='btnLogin']")
   WebElement login;
   
   public void typeUserName(String username)
   {
	   userName.sendKeys(username);
   }
   public void typePassword(String password1)
   {
	   password.sendKeys(password1);
   }
   public void clickMethod()  
   {
      login.click();
   }
   
   public loginpage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
}
