package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartproductDescription {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'₹')]")
	private WebElement price;
	
	@FindBy(xpath = "(//div[contains(text(),'₹')])[1]")
	private WebElement maskPrice;
	
	@FindBy(xpath = "//a[text()='Free Size']")
	private WebElement maskSize;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement flipkartaddbtn;

	@FindBy(xpath = "//button[text()='GO TO CART']")
	private WebElement gotocart;
	
	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement carticon;
	
	public flipkartproductDescription(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement getPrice() {
		return price;
	}
	
	public WebElement getMaskPrice() {
		return maskPrice;
	}

	public WebElement getFlipkartaddbtn() {
		return flipkartaddbtn;
	}

	public WebElement getGotocart() {
		return gotocart;
	}

	public flipkartshoppingCart cart() {
		flipkartaddbtn.click();
		return new flipkartshoppingCart(driver);
	}
	
	public flipkartshoppingCart cart1() {
		maskSize.click();
		flipkartaddbtn.click();
		return new flipkartshoppingCart(driver);
	}
}
