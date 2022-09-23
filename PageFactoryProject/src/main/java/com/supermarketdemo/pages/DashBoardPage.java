package com.supermarketdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	

	WebDriver driver;
	@FindBy(xpath = ("(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]"))
	WebElement Category;
	@FindBy(xpath = ("//h1[@class='m-0 text-dark']"))
	WebElement titleCategory;
	@FindBy(xpath = ("//a[@class='d-block']"))
	WebElement adminLink;
	@FindBy(xpath = ("//a[@class='active nav-link']"))
	WebElement dashboard;

	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
