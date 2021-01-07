package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WorkingWithScreenshots {
	
	//Screenshot can be captured for a browser / element
	
	
	WebDriver Driver;
	
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\LTISeleniumTrainingBatch1\\Drivers\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://www.amazon.in/");
		
	}
	
	
	@AfterTest
	public void tearDown() {
		Driver.quit();
		
	}
	
	
	
	@Test(priority=1)
	public void getScreenShotOfPage() throws IOException {
		
		System.out.println("Screenshot of webpage");
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String DriverScreenshotname = "AmazonPage"; 
		
		TakesScreenshot SShot = (TakesScreenshot) Driver;
		
		File DriverSS = SShot.getScreenshotAs(OutputType.FILE);
		// destination
		
		String Destination  = System.getProperty("user.dir") + "/Screenshots/DriverScreenshot" + DriverScreenshotname + dateName + ".png" ;
		
		FileUtils.copyFile(DriverSS,new File(Destination));		
		
		
	}
	
	
	@Test(priority = 2)
	public void getWebElementScreenshot() throws IOException {
		System.out.println("Screenshot of web element on the page");
		
		String WebElementName = "AmazonLogo";
		
		File Src= Driver.findElement(By.id("nav-logo-sprites")).getScreenshotAs(OutputType.FILE);
		
		String Dest  = System.getProperty("user.dir") + "/Screenshots/DriverScreenshot" + WebElementName + System.currentTimeMillis() + ".png" ;
		
		FileUtils.copyFile(Src ,new File(Dest));		
		
	}
	
	@Test(priority=3)
	public void AshotScreenCapture() throws IOException {
		
		String FullPage = "AmazonFullPage";
		
		AShot FullScreen = new AShot();
		Screenshot SShot = FullScreen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Driver);
		
		//ImageIO.write(SShot.getImage(), "jpg", new File("D:\\LTI"));
		
		String Dest  = System.getProperty("user.dir") + "/Screenshots/DriverScreenshot" + FullPage + System.currentTimeMillis() + ".jpg" ;
		
		File FinalDestination = new File(Dest);
		
		ImageIO.write(SShot.getImage(), "jpg", FinalDestination);
	
	}
	
	
	
}
