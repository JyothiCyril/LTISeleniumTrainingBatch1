package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithActionClass {
	
	WebDriver Driver;
	Actions act;
	
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		act = new Actions(Driver);
		Driver.manage().window().maximize();
		Driver.get("https://www.amazon.in/");		
		
	}
	
	@Test
	public void MouseHOver() {
		
		
		WebElement Ele = Driver.findElement(By.id("nav-link-accountList"));
		
		act.moveToElement(Ele).build().perform(); // move the cursor position on to the specific element
		
		Driver.findElement(By.linkText("Start here.")).click();
		
		
		String title = Driver.getTitle();
		
		if(title.contains("Registration")) {
			Reporter.log(title,true);
		}
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		Driver.quit();
	}

}
