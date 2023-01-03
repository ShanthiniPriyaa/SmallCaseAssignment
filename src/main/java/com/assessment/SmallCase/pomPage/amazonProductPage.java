package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonProductPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//span[contains(text(),'Bildos Cotton')])[1]")
	private WebElement mask;
	
	public amazonProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public amazonproductDescription description() {
		mask.click();
		return new amazonproductDescription(driver);
	}
}
