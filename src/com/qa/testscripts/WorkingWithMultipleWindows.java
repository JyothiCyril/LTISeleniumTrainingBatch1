package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class WorkingWithMultipleWindows {
	
	WebDriver Driver;
	RediffPages RediffOR;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		RediffOR = new RediffPages(Driver);
		Driver.get("https://www.rediff.com/"); // first page
		
	}
	
	
	@AfterTest
	public void tearDown() {
		Driver.quit();
		
	}

	
	
	@Test(priority=1)
	public void CreateAccount() {
		RediffOR.setNewRegistrationLinkClick();
	}
	
	
	@Test(priority=2, dependsOnMethods="CreateAccount")
	public void MultipleWindows() {
		
		RediffOR.setPrivacyPoliciyLinkClick(); // 2nd page
		RediffOR.setTermandConditionsLink(); // 3rd page
		
		Set<String> windowHandles = Driver.getWindowHandles();
		
		
		Iterator<String> iter = windowHandles.iterator();
		
		// 1st window
		String id1 = iter.next(); // 1st window
		WebDriver RediffPage = Driver.switchTo().window(id1);
		Reporter.log(RediffPage.getTitle(),true);
		
		
		// 2nd window
		String id2 = iter.next(); // 2nd window
		WebDriver window2= Driver.switchTo().window(id2);
		Reporter.log(window2.getTitle(), true);
		
		// 3rd window
		String id3 = iter.next(); // 3rd window
		WebDriver window3= Driver.switchTo().window(id3);
		Reporter.log(window3.getTitle(),true);
		
		
		
	}
}
