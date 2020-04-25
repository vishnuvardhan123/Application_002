package com.application.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.application.Utilites.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String url = readconfig.getApplicationUrl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br) {
		
		logger = Logger.getLogger("Banking");
		
		//PropertyConfigurator.configure("Log4j.properties");
		
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
			
			driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver",readconfig.getfirepath());
			
			driver = new FirefoxDriver();
			
		}
		
		else if(br.equals("ie")){
			
			System.setProperty("webdriver.ie.driver",readconfig.getiepath());
			
			driver = new InternetExplorerDriver();
		
		
	}
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}
	
	@AfterClass
	
	public void teardown() {
	
		driver.quit();

	}
	public void screenshot(WebDriver driver , String tname) {
		
		DateFormat df = new SimpleDateFormat("dd-MM-YYYY-h-m");
		
		Date date = new Date();
		
		String time = df.format(date);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + time + tname + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
		
	}
	
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		
		return (generatedString2);
	}
	

}
