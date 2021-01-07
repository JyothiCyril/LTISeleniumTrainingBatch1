package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WorkingWithDragAndDrop {
	
	
	@Test
	public void DragDropAction() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Actions act = new Actions(Driver);
		Driver.manage().window().maximize();
		Driver.get("https://jqueryui.com/droppable/");
		Driver.switchTo().frame(0);
		
		WebElement DragEle = Driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]")); // element to be drag & hold
		
		
		WebElement DropEle = Driver.findElement(By.id("droppable")); // Place where to drop the element dragged
		
		act.clickAndHold(DragEle).moveToElement(DropEle).release().build().perform();
		
		Thread.sleep(5000);
		
		
		
	}

}
