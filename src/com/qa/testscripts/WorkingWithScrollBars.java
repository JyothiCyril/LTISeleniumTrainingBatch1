package com.qa.testscripts;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWithScrollBars {
	
	@Test
	public void ScrollBars() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://www.amazon.in");
		
		JavascriptExecutor Js = (JavascriptExecutor) Driver;
		
		// scroll by co-ordinates
//		(0,500) --> x--> horizontal, Y --> vertical scroll
	
		
		for(int i=0; i<5;i++) {
			Js.executeScript("window.scrollBy(0,500)"); //top to down	
			Thread.sleep(2000);
		}
	
		Thread.sleep(5000);
		
		
		for(int i=5; i>=1;i--) {
			Js.executeScript("window.scrollBy(0,-500)"); //top to down	
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
		
		// scroll by element presence
		
		WebElement element = Driver.findElement(By.xpath("//a[contains(text(),'Careers')]"));
		
		
		Js.executeScript("arguments[0].scrollIntoView()", element);
		
		
		element.click();
		
		Thread.sleep(2000);
		
	}
	
	
	
		
	
	
	
	
	
	
	
	

}
