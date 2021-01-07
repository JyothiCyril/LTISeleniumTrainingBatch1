package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWithWebTables {
	
	
	@Test
	public void WebTables() {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		
		Driver.get("https://www.selenium.dev/downloads/");
		
		List<WebElement> TRow = Driver.findElements(By.tagName("tr")); // get all the row in the entire html page
		System.out.println(TRow.size());
		
		
		List<WebElement> TData = Driver.findElements(By.tagName("td")); // get all the data in the entire html page
		System.out.println(TData.size());
		
		for(WebElement data : TData) {
			System.out.println(data.getText());
		}
		
		
		
		Driver.quit();
		
	}
	

}
