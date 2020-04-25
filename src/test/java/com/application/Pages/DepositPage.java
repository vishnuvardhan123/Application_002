package com.application.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
	
	WebDriver Idriver;
	
	

	public DepositPage(WebDriver rdriver) {
		
		Idriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	

	@FindBy(xpath="/html/body/div[3]/div/ul/li[8]/a")
	@CacheLookup
	WebElement btndeposit;
	
	@FindBy(name="accountno")
	@CacheLookup
	WebElement accnum;
	
	@FindBy(name="ammount")
	@CacheLookup
	WebElement amunt;
	
	@FindBy(name="desc")
	@CacheLookup
	WebElement text;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement btnsubmit;
	
	
	public void deposit() {
		
		btndeposit.click();
	}
	
	public void  setaccountno(String acc) {
		
		accnum.sendKeys(acc);
	}
	
	public void  setamount(String amount) {
		
		amunt.sendKeys(amount);
	}
	
	public void  setdescrp(String data) {
		
		text.sendKeys(data);
		
	}
		
	public void  submitamt() {
		
		btnsubmit.click();
		
	}
		
}
