package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazoncartPage {
	
	public WebDriver driver;
	
	@FindBy(id = "sw-gtc")
	private WebElement gotocartbtn;
	
	public amazoncartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public amazonShoppingcart cartpage() {
		gotocartbtn.click();
		return new amazonShoppingcart(driver);
	}
}
