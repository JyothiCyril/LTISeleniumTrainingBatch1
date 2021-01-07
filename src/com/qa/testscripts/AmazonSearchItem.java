package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearchItem {

	/*
	 * 1. Open the browser 2. Run Amazon URL 3. Type " Da vinci code" 4. Click on
	 * magnifier button 5. get the title and check if the browser title have changed
	 * to da vinci code
	 * 
	 * 5.1 Get all the items loaded --> Count and names. 6. Close
	 */

	public static void main(String[] args) throws InterruptedException {
		
		
		//System.out.println("Test Case is Passed....");
	//}
		String input = "Da vinci code";

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		
		
		
		
		Driver.get("http://www.amazon.in");
		
		
		// Select the value from Categories...
		
		
		Select Category = new Select(Driver.findElement(By.id("searchDropdownBox")));
		
		Category.selectByValue("search-alias=fashion");
		Thread.sleep(2000);
		
		Category.selectByIndex(5);
		Thread.sleep(2000);
		
		Category.selectByVisibleText("Books");
		Thread.sleep(2000);
		

		// On the webpage has a Test object, test object description (locator), Action (method), Test data (input)
		WebElement SearchTextField = Driver.findElement(By.id("twotabsearchtextbox"));
		
		SearchTextField.clear(); // clear the text on the element --> input
				
		
		SearchTextField.sendKeys(input);
		
		
		System.out.println(SearchTextField.getAttribute("value")); // any attribute value as HTML DOM --> Return String
		
		System.out.println(SearchTextField.getCssValue(input));
		
		System.out.println(SearchTextField.getSize().getWidth());
		
		System.out.println(SearchTextField.getTagName());
		
		System.out.println(SearchTextField.getText());
		
		
		Driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		String title = Driver.getTitle();
		
		if(title.contains(input)) {
			//System.out.println("Title is correct" + title);
			
			
			List<WebElement> ItemNames = Driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
			// on the webpage all the elements matching the xpath is loaded
			
			// get the count of elements
			
			System.out.println("Total no. of items loaded are : " + ItemNames.size());
			
			
			for(WebElement item : ItemNames ) {
				System.out.println(item.getText());
						
			}
			
		}else {
			System.out.println("Title is not correct");
		}
		
		
		Driver.close();

	}

}
