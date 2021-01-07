package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorkingWithFileUploadPopUp {
	
	@Test
	public void FileUploadPopUp() throws InterruptedException		{
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		
		Driver.get("https://www.naukri.com/account/createaccount");

		
		Driver.findElement(By.xpath("/html/body/div/form/div[2]/div/button")).click();
		
		Driver.findElement(By.name("uploadCV")).sendKeys("C:\\Users\\DELL\\Downloads\\TSL Course Contents- Specialization Phase.pdf");
		
		Thread.sleep(3000);
		
				
			}
	
	
}
