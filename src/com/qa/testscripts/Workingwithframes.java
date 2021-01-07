package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Workingwithframes {
	
	
	@Test
	public void frames() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		
		Driver.get("https://docs.oracle.com/javase/7/docs/api/");
		
		
		
		// locate the frames
		// switchTo the frame --> ID, name, by elements
		
		
		// switchTo frame by index
		
		
		
		/*
		 * int count = Driver.findElements(By.tagName("frame")).size(); for(int i=0;
		 * i<count ; i++) {
		 * 
		 * WebDriver frame = Driver.switchTo().frame(i);
		 * Reporter.log(frame.getTitle(),true);
		 * 
		 * List<WebElement> findElements = frame.findElements(By.tagName("a"));
		 * System.out.println("Total no. of links on the" + i +" frame are : " +
		 * findElements.size());
		 * 
		 * Driver.switchTo().defaultContent();
		 * 
		 * }
		 */
		 
		
		
		// Switch to a frame by name attribute
		
	//	WebElement FrameByName = Driver.findElement(By.name("packageListFrame"));
		
		WebElement findElement = Driver.findElement(By.xpath("/html/frameset/frame"));
		
		
		/*
		 * String FrameName = FrameByName.getAttribute("name");
		 * 
		 * Reporter.log(Driver.switchTo().frame(FrameName).getTitle(),true);
		 * 
		 * Driver.switchTo().defaultContent();
		 */
		
		
		
		
		// switch to frame by webelement...
		
		
		
		
		
		  WebDriver frame = Driver.switchTo().frame(findElement);
		  Reporter.log(frame.getTitle(),true);
		  
		  
		  List<WebElement> findElements = frame.findElements(By.tagName("a"));
		  System.out.println(findElements.size());
		  
		  for(WebElement link:findElements) { Reporter.log(link.getText(),true); }
		  
		  Driver.switchTo().defaultContent();
		 
		
		
		
	}
	

}
