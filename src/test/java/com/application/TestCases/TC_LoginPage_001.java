package com.application.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.application.Pages.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	
	public void loginpage() {
		
	LoginPage lp = new LoginPage(driver);
	
	lp.setusername(username);
	
	logger.info("Username entered");
	
	lp.setpassword(password);
	
	logger.info("Password entered");
	
	lp.loginbtn();
	
	logger.info("Login clicked");
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		screenshot(driver,"loginTest");
		
		Assert.assertTrue(true);
		
		logger.info("Login test passed");
	}
	else
	{
		screenshot(driver,"loginTest");
		
		Assert.assertTrue(false);
		
		logger.info("Login test failed");
	}
	
	lp.logoutbtn();
		
		
	}

}
