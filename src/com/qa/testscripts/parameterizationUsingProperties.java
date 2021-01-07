package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;



public class parameterizationUsingProperties {
	
	WebDriver Driver;
	AmazonPages AmazonOR;
	FileInputStream FileLoc;
	Properties Prop;
	

	@BeforeTest
	public void setUp() throws IOException {
		// opened the flatfile (properties in a read mode
		FileLoc = new FileInputStream("D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\src\\com\\qa\\Testdata\\Testdata.properties");
		Prop = new Properties();
		Prop.load(FileLoc);
		// Loading the file location opened in read mode into Properties...
		
		if(Prop.getProperty("Browser").contains("chrome"))
				
				{
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
			Driver = new ChromeDriver();
		 }
		
		AmazonOR = new AmazonPages(Driver);
	}
	
	@AfterTest
	public void tearDown() {
		
		Driver.close();
	}
	
	@BeforeClass
	public void LaunchURL() {
		Driver.get(Prop.getProperty("Url"));
	}

	@Test
	public void searchItem() {
		
		AmazonOR.SetCategoryList(Prop.getProperty("Category"));
		AmazonOR.setSearchInput(Prop.getProperty("Itemname"));
		AmazonOR.setMagnifierBtn();
		
		String Title = Driver.getTitle();
		Assert.assertTrue(Title.contains(Prop.getProperty("Itemname")), "Title is matching");
		
		Reporter.log(Title, true);
		
	}
}
