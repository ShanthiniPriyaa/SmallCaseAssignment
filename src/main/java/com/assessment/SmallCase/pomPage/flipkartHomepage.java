package com.assessment.SmallCase.pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkartHomepage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closeicon;
	
	@FindBy(name = "q")
	private WebElement searchtext;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//span[text()='Cart']")
	private WebElement carticon;
	
	@FindBy(xpath = "//div[text()='Beauty, Toys & More']")
	private WebElement toysmenu;
	
	@FindBy(xpath = "//a[text()='Nutrition & Health Care']")
	private WebElement nutrition;
	
	@FindBy(xpath = "//a[text()='Masks']")
	private WebElement mask;
	
	public flipkartHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement getToysmenu() {
		return toysmenu;
	}
	
	public WebElement getNutrition() {
		return nutrition;
	}
	
	public void closeCross() {
		closeicon.click();
	}

	public flipkartProductPage search(String searchProduct) {
		closeicon.click();
		searchtext.sendKeys(searchProduct);
		searchIcon.click();
		return new flipkartProductPage(driver) ;
	}
	
	public flipkartProductPage masks() {
		mask.click();
		return new flipkartProductPage(driver);
	}
	
	public flipkartshoppingCart cart() {
		closeicon.click();
		carticon.click();
		return new flipkartshoppingCart(driver);
	}
}
