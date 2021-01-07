package com.qa.testscripts;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.GooglePages;

public class ParameterizationUsingExcel {
	
	
	WebDriver Driver;
	GooglePages GoogleOR;
	FileInputStream FileLoc;
	XSSFWorkbook WorkBook;
	XSSFSheet Sheet;
	
	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		GoogleOR = new GooglePages(Driver);
		
		 // open the file in read mode.
		FileLoc= new FileInputStream("D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\src\\com\\qa\\Testdata\\InputData.xlsx");
		
		// open the input file as workbook
		WorkBook =new XSSFWorkbook(FileLoc);
		
		// Read the worksheet with in the work book. 
		Sheet = WorkBook.getSheet("Sheet1");
		
		
		Driver.get("https://www.google.com/");
		
	}

	
	@AfterMethod
	public void tearDown() throws IOException {
		Driver.close();
		FileLoc.close();
	}
	
	@Test(priority=2)
	public void GoogleSearch() throws InterruptedException {
		
		// get hte total no. of row in the work sheet
		int lastRowNum = Sheet.getLastRowNum(); // return the no. of rows
		
		// How many columns are there based on the total no. of cells 
		
		short lastCellNum = Sheet.getRow(0).getLastCellNum(); // returns no. of cells in each row // column values
		
		// Loop iterated till the last row of the sheet...
		
		for(int i=1 ; i<=lastRowNum; i++) {
			
			XSSFRow row = Sheet.getRow(i);
			
			
			//iterated to the last cell of the current row
			for(int j=0; j<lastCellNum ; j++) {
				
				String SearchItem = row.getCell(j).toString();
				
				GoogleOR.setinputSearchTextBox(SearchItem);
				Thread.sleep(3000);
						
				List<WebElement> autoSuggest = GoogleOR.getAutoSuggest();
				for(WebElement item : autoSuggest) {
					Reporter.log(item.getText(),true);
				}
					
				Thread.sleep(2000);
				GoogleOR.setinputSearchTextBoxSubmit();
				
				// getTitle and chack if it is same as search term
				Assert.assertTrue(Driver.getTitle().contains(SearchItem));
			}
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	/*
	 * @Test(priority=1) public void checkTitle() {
	 * Assert.assertTrue(Driver.getTitle().contains("Google"));
	 * 
	 * }
	 */

}
