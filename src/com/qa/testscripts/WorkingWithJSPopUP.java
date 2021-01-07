package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWithJSPopUP {
	
	
	
	@Test
	public void popup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.get("file:///D:/Popup1.html");
		
		Driver.findElement(By.xpath("/html/body/fieldset/button")).click();
		
		// pop will be generated...
		
		System.out.println(Driver.switchTo().alert().getText());
		Thread.sleep(5000);
		
		//Driver.switchTo().alert().accept();
		
		Driver.switchTo().alert().dismiss();
		
		Driver.close();
	}
	
	
	

}
