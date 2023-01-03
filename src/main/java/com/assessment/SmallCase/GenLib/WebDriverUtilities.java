package com.assessment.SmallCase.GenLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	
	public void dropdown(WebElement ele, String text) {
		Select s =  new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void moveByOffset(WebDriver driver, int x, int y) {
		Actions a = new Actions(driver);
		a.moveByOffset(x,y).perform();
	}

	public void rightClick(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	public void dragandDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	public void ClickandHold(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.clickAndHold(src).moveToElement(dest).release().perform();
	}
	
	public void switchFrames(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	public void switchBackFrames(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void alertPopupAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchingTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b : child) {
			driver.switchTo().window(b);
		}
	}
	
	public void switchingWindow(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for(String b : child) {
			driver.switchTo().window(b);
		}
	}
	
	public void scrollBar (WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy("+x+" , "+y+")");
	}
	
	public void jsClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void jsView(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public void keyboardAction(WebDriver driver, int keycode, int keycode1) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);
		r.keyPress(keycode);
		r.keyRelease(keycode);
		r.keyRelease(keycode1);
	}
}
