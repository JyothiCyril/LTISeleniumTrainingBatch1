package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pages.RediffPages;

public class ExtentReportExample {
	
	ExtentHtmlReporter HtmlReport;
	ExtentReports XReports;
	ExtentTest XTest;   
	WebDriver Driver;
	RediffPages RediffOR;
	
	@BeforeTest
	public void startTest() {
		
		HtmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/MyHTMLReport.html");
		HtmlReport.config().setDocumentTitle("Automation Testing");
		HtmlReport.config().setReportName("Regression Test Cycle 1");
		HtmlReport.config().setTheme(Theme.DARK);
		HtmlReport.config().setAutoCreateRelativePathMedia(true);
				
		XReports = new ExtentReports();
		XReports.attachReporter(HtmlReport);
		XReports.setSystemInfo("Browser", "Chrome");
		XReports.setSystemInfo("OS", "WINDOWS 10");
		XReports.setSystemInfo("QA Name", "Smith");
	}

	
	
	@AfterTest
	public void endTest() {
		XReports.flush();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		RediffOR = new RediffPages(Driver);
		Driver.get("https://www.rediff.com/");
	}
	
	@Test(priority=1)
	public void GetTitle() {
		XTest = XReports.createTest("GetTitle");
		String title = Driver.getTitle();
		Assert.assertTrue(title.contains("Welcome to Rediff"));
		
	}
	
	@Test(priority=2)
	public void createAccount() {
		XTest = XReports.createTest("createAccount");
		
		RediffOR.setNewRegistrationLinkClick();
		
		String title = Driver.getCurrentUrl();
		Assert.assertTrue(title.contains("register"));
		
		
	}
	
	@Test(priority=3)
	public void SignIn() {
		XTest = XReports.createTest("SignIn");
		
		RediffOR.setSiginLinkClick();		
		String title = Driver.getCurrentUrl();
		Assert.assertTrue(title.contains("User login"));
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult results) throws IOException {
		
		if(results.getStatus() == ITestResult.FAILURE) {
			XTest.log(Status.FAIL, "Test failed is :" + results.getName());
			XTest.log(Status.FAIL, "Test failed is :" + results.getThrowable());
			
			String SSPath = ExtentReportExample.getScreenShot(Driver, results.getName());
			XTest.addScreenCaptureFromPath(SSPath);
			
			
		}else if(results.getStatus() == ITestResult.SUCCESS) {
			XTest.log(Status.PASS, "Test passed is :" + results.getName());
		}else if(results.getStatus() == ITestResult.SKIP) {
			XTest.log(Status.SKIP, "Test Skipped is :" + results.getName());
		}
		
		
		Driver.quit();
		
	}
	
	
	public static String getScreenShot(WebDriver Driver , String ScreenshotName) throws IOException {
		
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot SShot = (TakesScreenshot) Driver;
		
		File Source = SShot.getScreenshotAs(OutputType.FILE);
		// destination
		
		String Destination  = System.getProperty("user.dir") + "/Screenshots/DriverScreenshot" + ScreenshotName + dateName + ".png" ;
		
		FileUtils.copyFile(Source,new File(Destination));	
		
		return Destination;
	}
	
	
	
	
}
