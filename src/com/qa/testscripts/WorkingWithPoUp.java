package com.qa.testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;



public class WorkingWithPoUp {
	
	
	WebDriver Driver;
	RediffPages RediffOR;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		RediffOR = new RediffPages(Driver);
;		Driver.get("https://www.rediff.com/"); // first page
		
	}
	
	
	@AfterTest
	public void tearDown() {
		Driver.quit();
		
	}
	
	
	@Test
	public void SigIn() throws InterruptedException {
		
		RediffOR.setSiginLinkClick();
		
		RediffOR.setSigInButtonClick(); // pop generated as the Uname & pwd fields are empty.
		
		Alert Jsalert = Driver.switchTo().alert();
		
		Reporter.log(Jsalert.getText(),true);
		Jsalert.accept();
		
		
		Thread.sleep(5000);
		//
	}

}
