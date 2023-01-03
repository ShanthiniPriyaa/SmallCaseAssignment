package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartProductPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//a[contains(text(),'Mi 3i 10000 mAh')])[1]")
	private WebElement mi;
	
	@FindBy(xpath = "(//a[contains(text(),'BILDOS 3 Layer')])[1]")
	private WebElement bildosmask;
	
	public flipkartProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public flipkartproductDescription products() {
		mi.click();
		return new flipkartproductDescription(driver);
	}
	
	public flipkartproductDescription maskProduct() {
		bildosmask.click();
		return new flipkartproductDescription(driver);
	}
}
