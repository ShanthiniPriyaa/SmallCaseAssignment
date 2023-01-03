package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonShoppingcart {
	
	public WebDriver driver;
	
	@FindBy(id = "sc-subtotal-amount-buybox")
	private WebElement subtotal;
	
	public amazonShoppingcart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getSubtotal() {
		return subtotal;
	}
}
