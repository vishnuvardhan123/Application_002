package com.application.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver Idriver;
	
	public LoginPage(WebDriver rdriver) {
		
		Idriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
		
	}
	
@FindBy(name = "uid")
@CacheLookup
WebElement txtusername;

@FindBy(name = "password")
@CacheLookup
WebElement txtpassword;

@FindBy(name = "btnLogin")
@CacheLookup
WebElement btnlogin;

@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
@CacheLookup
WebElement btnlogout;

public void setusername(String uname) {
	
	txtusername.sendKeys(uname);
}

public void setpassword(String pass) {
	
	txtpassword.sendKeys(pass);
}

public void loginbtn() {
	
	btnlogin.click();
}

public void logoutbtn() {
	
	btnlogout.click();
}
}
