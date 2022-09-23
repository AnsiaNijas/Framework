package com.supermarketdemo.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriverWait w;
	public void waitAttributeContains(WebDriver driver,By property, String type,String value)
	{
		w=new WebDriverWait(driver, Duration.ofSeconds(4));
		w.until(ExpectedConditions.attributeContains(property, type, value));
	}
	
	public void waitPresenceOfElementLocated(WebDriver driver,By property)
	{
		w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(property));
	}
	
	public void waitAlertsPresent(WebDriver driver)
	{
		w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.alertIsPresent());
	}
	public void fluentWait(WebDriver driver,By property)
	{
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(100))
				  .pollingEvery(Duration.ofSeconds(10))
				  .ignoring(Exception.class);
		  wait.until(ExpectedConditions.elementToBeClickable(property));
	}

}
