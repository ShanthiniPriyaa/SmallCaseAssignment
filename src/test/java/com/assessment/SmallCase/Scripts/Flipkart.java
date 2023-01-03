package com.assessment.SmallCase.Scripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.assessment.SmallCase.GenLib.BaseClass;
import com.assessment.SmallCase.pomPage.flipkartHomepage;
import com.assessment.SmallCase.pomPage.flipkartProductPage;
import com.assessment.SmallCase.pomPage.flipkartproductDescription;
import com.assessment.SmallCase.pomPage.flipkartshoppingCart;

public class Flipkart extends BaseClass {
	
	@Test
	
	public void scenario1() throws IOException, InterruptedException {
		
		test=reports.createTest("scenario1");
		
		flipkartHomepage Home = new flipkartHomepage(driver);
		flipkartProductPage productPage = Home.search(fu.getPropertydata("searchProduct"));
		flipkartproductDescription productDescription = productPage.products();
		String text = productDescription.getPrice().getText().replaceAll("₹", "");
		System.out.println(text);
		
		utility.switchingTabs(driver);
		
		flipkartshoppingCart cartpage = productDescription.cart();
		
		utility.jsView(driver, cartpage.getPlus());
		
		utility.jsClick(driver, cartpage.getPlus());
		
		Thread.sleep(3000);	
		
		String totaltext = cartpage.getTotalPrice().getText().replaceAll("₹", "");
		System.out.println(totaltext);
	}
}
