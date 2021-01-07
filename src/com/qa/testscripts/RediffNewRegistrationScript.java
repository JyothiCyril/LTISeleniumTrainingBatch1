package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class RediffNewRegistrationScript {
	
	WebDriver Driver;
	RediffPages RediffOR;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		
		RediffOR = new RediffPages(Driver);
		Driver.get("https://www.rediff.com/");
		
	}
	
	
	@Test(priority=1)
	public void ClickOnRegisterlink() {
			
		
		
		System.out.println(RediffOR.getNewRegistrationLink());
		RediffOR.setNewRegistrationLinkClick();
		
		if(Driver.getCurrentUrl().contains("register")) {
			System.out.println("Registration page is loaded");
		}
		
		
	}
	
	@Test(priority=2)
	public void SignInlInk() {
		
		Driver.findElement(By.linkText("Sign in"));
		
		//D:\SeleniumTraining\LTISeleniumTrainingBatch1\Drivers\chromedriver.exeAssert.assertTrue(Driver.getCurrentUrl().contains("login"));
		
		/*if(Driver.getCurrentUrl().contains("login")) {
			System.out.println("Login page is loaded");
		}else {
			System.out.println("No page found");
		}
		*/
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		Driver.close();
	}
	

}
