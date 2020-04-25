package com.application.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.application.Pages.DepositPage;
import com.application.Pages.LoginPage;

public class TC_Deposit_002 extends BaseClass {
	
	@Test
	
	public void depositamount() throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setusername(username);
		
		logger.info("username entered");
		
		lp.setpassword(password);
		
		logger.info("password entered");
		
		lp.loginbtn();
		
		logger.info("login btn clicked");
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[8]/a"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click();", ele);
		
		Thread.sleep(2000);
		
		DepositPage dp = new DepositPage(driver);
		
		//Contact_Element.clickbyXpath(driver, "/html/body/div[3]/div/ul/li[8]/a");
		
		dp.setaccountno("34195");
		
		logger.info("Account No Entered");
		
		dp.setamount("1000");
		
		logger.info("Amount Entered");
		
		dp.setdescrp("Pay");
		
		logger.info("Description Entered");
		
		Thread.sleep(2000);
		
		dp.submitamt();
		
		String txt = driver.findElement(By.xpath("//*[text()='Transaction details of Deposit for Account 76583']")).getText();
		
		if(txt.contains("Transaction details of Deposit for Account 76583")) {
			
			System.out.println("Amount Deposited Successfully");
			
			logger.info("Deposit test successfully completed");
			
		}
		
		else {
			
			System.out.println("Amount Not Deposited");
			
			screenshot(driver,"Deposit Test");
		}
	
		
		
	}

}
