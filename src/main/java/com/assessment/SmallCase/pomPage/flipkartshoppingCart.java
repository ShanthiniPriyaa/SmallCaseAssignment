package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartshoppingCart {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//button[@class='_23FHuj'])[2]")
	private WebElement plus;
	
	@FindBy(xpath = "//span[@class='_2-ut7f _1WpvJ7']")
	private WebElement totalPriceforMI;
	
	@FindBy(xpath = "(//span[contains(text(),' ₹')])[2]")
	private WebElement totalpriceforMask;
	
	public flipkartshoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void quantity() {
		plus.click();
	}

	public WebElement getPlus() {
		return plus;
	}

	public WebElement getTotalPrice() {
		return totalPriceforMI;
	}

	public WebElement getTotalpriceforMask() {
		return totalpriceforMask;
	}
}
