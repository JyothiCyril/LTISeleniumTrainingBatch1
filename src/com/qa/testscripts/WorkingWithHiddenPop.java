package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWithHiddenPop {
	
	
	@Test
	public void Hiddenpopup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		
		Driver.get("https://www.cleartrip.com/");
		
		
		Driver.findElement(By.id("DepartDate")).click();
		
		Driver.findElement(By.xpath("(//a[.='8'])[1]")).click();
		
		Thread.sleep(3000);
		
	}

}
