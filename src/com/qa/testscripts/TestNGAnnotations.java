package com.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	
	@BeforeGroups("Billpayment")
	public void  before_Billpayment() {
		System.out.println("I am before groups method");
	}
	
	@AfterGroups("Billpayment")
	public void  After_Billpayment() {
		System.out.println("I am After groups method");
	}
		
	@BeforeClass
	public void Login() {
		System.out.println("I am Login method");
	}
	
	@AfterClass
	public void Logout() {
		System.out.println("I am Logout method");
	}
	
	@Test(priority=0)
	public void CheckBalance() {
		System.out.println("I am check balance method");
		//Assert.assertTrue(false);
	}
	//
	@Test(priority=1, dependsOnMethods="CheckBalance")
	public void Fundtransfer() {
		System.out.println("I am fundtransfer method");
	}
	
	@Test(priority=2,groups = "Billpayment")
	public void Creditcard_BillPayment() {
		System.out.println("I am a creditcard bill payment method");
	}
	//
	@Test(priority=3,groups = "Billpayment")
	public void UtilityBillPayment() {
		System.out.println("I am Utility bill payment method");
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("Invoke the browser & open an URL");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Delete all cookies & Close the browser");
	}
	

}
