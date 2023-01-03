package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonHomepage {
	
	public WebDriver driver;
	
	@FindBy(id = "searchDropdownBox")
	private WebElement dropdown;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchtext;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchicon;
	
	public amazonHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	
	public amazonProductPage product(String productName) {
		searchtext.sendKeys(productName);
		searchicon.click();
		return new amazonProductPage(driver);
	}
}
