package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsofWebDriver {

	public static void main(String[] args) {

		
		// Define the driver binaries
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver Driver = new ChromeDriver(); // invoke the browser --> Getting the reference of ChromeDriver class and storing in to the Driver variable / boject --> Declared as WebDriver
		Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		Driver.get("http://www.amazon.in/"); // It should always be used after the driver / browser is invoked
		// Run the URL  on the browser and wait till it is loaded
		
		// All the sequence test step should be written between the get() and before close() / quit().
		
		//Driver.findElement(); // Abstract method from search context class : Find and element or an object, further to which what action to be done
		
		
		//Driver.findElements( ); // Group element and actions to be performed on them --> return list of elements of similar category
		
		///To work with findelement / findelements --> concept of locators is mandatory
		
	
		
		//System.out.println(Driver.getCurrentUrl()); // get the current URL of the page at the run session --> Returns String as output
		
		
		//System.out.println(Driver.getPageSource()); // Get the HTML page source of the webpage --> output format is "String"
		
		
		WebDriverWait ExpWait = new WebDriverWait(Driver, 10);
		ExpWait.until(ExpectedConditions.titleContains("Amazon"));
		
		
		System.out.println(Driver.getTitle()); // get the title of the webpage --> String as output
		
		//	Driver.getWindowHandle() & Driver.getWindowHandles() ; // get the total no. of tabs / windows opened on the current browser instance..
		// We can use the above 2 methods with support of switchTo()
		
		
		// Driver.switchTo() --> helps to switch to an Alert / another tab or window / from one frame to another frame with in same window
		
		
		// Driver.navigate().back(); // navigate to previous page --> forward / refresh / url etc..
		
		
		
		
		Driver.close(); // Close the browser --> Recommended to be used at the end of the script
		// Driver gets terminated after close / quite method --> Driver.quit();
		
		
		// close will close / terminate only the respective browser instance
	
	//	Driver.quit(); // close the current browser along with the popup windows opened / multiple tabs / windows opened
		
		//** Dont use both , either use close() / quit();
		
		
	}

}
