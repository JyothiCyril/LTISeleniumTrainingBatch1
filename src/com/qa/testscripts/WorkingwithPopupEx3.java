package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingwithPopupEx3 {
	
	
	@Test
	public void popup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.get("file:///D:/Popup2.html");
		
		Driver.findElement(By.xpath("/html/body/fieldset/button")).click();
		
		// pop will be generated...
		
		System.out.println(Driver.switchTo().alert().getText());
		Thread.sleep(5000);
		
		Driver.switchTo().alert().accept();
		
		//Driver.switchTo().alert().dismiss();
		String text = Driver.findElement(By.id("confirmdemo")).getText();
		
		if(text.contains("You Clicked on Cancel!")) {
			System.out.println("User has selected Dismiss option");
		} else {
			System.out.println("User has selected Ok option");
		}
		
		Driver.close();
	}
	
	

}
