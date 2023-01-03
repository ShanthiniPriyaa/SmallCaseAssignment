package com.assessment.SmallCase.GenLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public FileUtilities fu = new FileUtilities();
	public WebDriverUtilities utility = new WebDriverUtilities();
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeSuite
	
	public void configBS() {
	
	htmlreport = new ExtentHtmlReporter(AutoConstant.reportsPath);
	htmlreport.config().setDocumentTitle("Report");
	htmlreport.config().setTheme(Theme.DARK);
	reports = new ExtentReports();
	reports.attachReporter(htmlreport);
	
	}
	
	@BeforeMethod
	
	public void openApp() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertydata("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	
	public void closeApp(ITestResult res) throws IOException {
		
		int result = res.getStatus();
		
		if (result == ITestResult.FAILURE) {
			test.log(Status.FAIL, res.getName() + "Test Case is Failed");
			test.log(Status.FAIL, res.getThrowable() + "Test Case is Failed Exception");
		}
		else if (result == ITestResult.SUCCESS) {
			test.log(Status.PASS, res.getName() + "Test Case is Passed");
		}
		else if (result == ITestResult.SKIP) {
			test.log(Status.SKIP, res.getName() + "Test Case is Skipped");
		}
		
		String name = res.getName();
		if(result == 2) {
			Photo p = new Photo();
			p.getPhoto(driver, name);
		}
		
		driver.quit();
	}
	
	@AfterSuite
	
	public void configAs() {
		htmlreport.flush();
		reports.flush();
	}
}
