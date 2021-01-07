package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	
	@Test
	public void windowa() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		
		Driver.get("https://www.online.citibank.co.in/"); // 1 window
		
		Driver.findElement(By.linkText("CITIGROUP.COM")).click(); // 2nd window
		Driver.findElement(By.linkText("TERMS AND CONDITIONS")).click(); // 3rd window
		
		Set<String> windowHandles = Driver.getWindowHandles(); // How many #of browser tabs are opened currently.
		
		Iterator<String> iterator = windowHandles.iterator();
		
		String id1 = iterator.next();
		System.out.println(id1);
		System.out.println(Driver.switchTo().window(id1).getTitle());
		
		String id2 = iterator.next();
		System.out.println(id2);
		System.out.println(Driver.switchTo().window(id2).getTitle());
		
		//WebDriver DriverPage = Driver.switchTo().window(id2);
		
		
		String id3 = iterator.next();
		System.out.println(id3);
		System.out.println(Driver.switchTo().window(id3).getTitle());
		
		Driver.quit();
	}
	

}
