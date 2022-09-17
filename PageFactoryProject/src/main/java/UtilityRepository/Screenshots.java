package UtilityRepository;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {

	public void captureScreenshot(WebDriver driver, String methodName) throws IOException
    {
		  Date d=new Date();
		  String date=d.toString().replace(":","_").replace(" ","_")+".png";
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source =ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source,new File("./Screenshots/"+methodName+ date)); 
	      
  }

}
