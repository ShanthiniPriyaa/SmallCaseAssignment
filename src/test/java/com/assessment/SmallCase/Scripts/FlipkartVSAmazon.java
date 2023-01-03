package com.assessment.SmallCase.Scripts;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.Test;

import com.assessment.SmallCase.GenLib.BaseClass;
import com.assessment.SmallCase.pomPage.amazonHomepage;
import com.assessment.SmallCase.pomPage.amazonProductPage;
import com.assessment.SmallCase.pomPage.amazonShoppingcart;
import com.assessment.SmallCase.pomPage.amazoncartPage;
import com.assessment.SmallCase.pomPage.amazonproductDescription;
import com.assessment.SmallCase.pomPage.flipkartHomepage;
import com.assessment.SmallCase.pomPage.flipkartProductPage;
import com.assessment.SmallCase.pomPage.flipkartproductDescription;
import com.assessment.SmallCase.pomPage.flipkartshoppingCart;

public class FlipkartVSAmazon extends BaseClass {
	
@Test
	
	public void scenario2() throws InterruptedException, IOException, AWTException {
	
		test=reports.createTest("scenario2");
		
		flipkartHomepage Home = new flipkartHomepage(driver);
		Home.closeCross();
		utility.mouseHover(driver, Home.getToysmenu());
		utility.mouseHover(driver, Home.getNutrition());
		flipkartProductPage productPage = Home.masks();
		flipkartproductDescription productDescription = productPage.maskProduct();
		String text = productDescription.getMaskPrice().getText().replaceAll("₹", "");
		System.out.println(text);
		
		utility.switchingTabs(driver);
		
		flipkartshoppingCart cartpage = productDescription.cart1();
		
		String text1 = cartpage.getTotalpriceforMask().getText().replaceAll("₹", "");
		
		System.out.println(text1);
		
		utility.keyboardAction(driver, KeyEvent.VK_CONTROL, KeyEvent.VK_T);
		
		utility.switchingTabs(driver);
		
		driver.get(fu.getExcelData("Sheet1", 1, 0));
		
		amazonHomepage amazonhome = new amazonHomepage(driver);
		utility.dropdown(amazonhome.getDropdown(), fu.getPropertydata("amazondd"));
		amazonProductPage amazonproduct = amazonhome.product(fu.getPropertydata("productName"));
		amazonproductDescription amazonprodescription = amazonproduct.description();
		String text2 = amazonprodescription.getPrice().getText().replaceAll("₹","");
		System.out.println(text2);
		
		utility.switchingTabs(driver);
		
		amazoncartPage amazoncartpage = amazonprodescription.cart1();
		amazonShoppingcart amazonshopcart = amazoncartpage.cartpage();
		String text3 = amazonshopcart.getSubtotal().getText().replaceAll("₹","");
		System.out.println(text3);
		
		int flipkart = Integer.parseInt(text1);
		int amazon = (int) Double.parseDouble(text3);
		
		if(flipkart < amazon)
			System.out.println("Flipkart price is Cheap");
			
		else if(flipkart > amazon)
				System.out.println("Amazon price is Cheap");
				
		else
				System.out.println("Both Price is Same");
	}
}
