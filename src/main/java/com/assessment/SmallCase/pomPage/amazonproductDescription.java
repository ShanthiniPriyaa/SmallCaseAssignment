package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonproductDescription {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	private WebElement price;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement amazonaddbtn;
	
	public amazonproductDescription(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getPrice() {
		return price;
	}
	
	public WebElement getAmazonaddbtn() {
		return amazonaddbtn;
	}

	public amazoncartPage cart1() {
		amazonaddbtn.click();
		return new amazoncartPage(driver);
	}
}
