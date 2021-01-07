package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;



public class ParameterizationUsingDataProvider {
	
	
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
		
		Driver.manage().window().maximize();
		Driver.get(Prop.getProperty("Url"));
	}
	
	@AfterTest
	public void tearDown() {
		
		Driver.close();
	}
	

	@Test(dataProvider="getData")
	public void searchItem(String Category, String ItemName) {
		
		/*
		 * WebDriverWait ExWait = new WebDriverWait(Driver,40);
		 * 
		 * WebElement ele = Driver.findElement(By.id("searchDropdownBox"));
		 * ExWait.until(ExpectedConditions.presenceOfElementLocated(By.id(
		 * "searchDropdownBox")));
		 * ExWait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)
		 * ));
		 */
		
		Driver.navigate().refresh();
		
		//System.out.println(AmazonOR.getCategoryListDisplayed());
		//Driver.navigate().to(Prop.getProperty("Url"));
		AmazonOR.SetCategoryList(Category);
		
		//System.out.println(AmazonOR.getSearchInputDisplayed());
		
		AmazonOR.setSearchInput(ItemName);
		AmazonOR.setMagnifierBtn();
		
		String Title = Driver.getTitle();
		Assert.assertTrue(Title.contains(ItemName), "Title is matching");
		
		Reporter.log(Title, true);
		//Driver.navigate().refresh();
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][]	data = new Object[3][2];
		
		// category
		data[0][0] = "Books";
		data[1][0] = "Furniture";
		data[2][0] = "Electronics";
		
		
		// search item
		
		data[0][1] = "Da vinci code";
		data[1][1] = "Wooden Tables";
		data[2][1] = "Washing machines";
		
		return data;
	}
	
	

}
