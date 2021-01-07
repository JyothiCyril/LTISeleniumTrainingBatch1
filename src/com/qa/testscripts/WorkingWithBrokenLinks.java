package com.qa.testscripts;



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;



public class WorkingWithBrokenLinks {
	WebDriver Driver;
	AmazonPages AmazonOR;
	String Hpage;
	HttpURLConnection huc = null;
	
	@BeforeTest
	public void setUp() {
		
		Hpage ="https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		AmazonOR = new AmazonPages(Driver);
		Driver.get(Hpage);
	
	}
	
	
	
	@AfterTest
	public void tearDown() {
		
		Driver.close();
		
	}
	
	@Test(priority=1)
	public void getAllLinks() {
		
		
		List<WebElement> allLinks = AmazonOR.getAllLinks();
		
		System.out.println("Total no. of links are:" + allLinks.size());
		
		for(WebElement link : allLinks) {
			//System.out.println(link.getAttribute("href"));
			
			
			String Url = link.getAttribute("href");
			
			if(Url==null || Url.isEmpty()) {
				
				System.out.println("URL is not configured else it empty");
				continue;
			}
			
			if(!Url.startsWith(Hpage)) {
				System.out.println(" URL belongs to anotaher application");
				continue;
			}
			
			try {
				
				huc = (HttpURLConnection) (new URL(Url).openConnection());
				
				huc.setRequestMethod("HEAD");
				huc.connect();
				int responseCode = huc.getResponseCode();
				
				
				if(responseCode>=400) {
					
					System.out.println(Url + "is a broken link");
				}else {
					System.out.println(Url + "is a valid link");
				}
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	

}
