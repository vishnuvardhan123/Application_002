package com.application.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()  {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fi = new FileInputStream(src);
			
			prop = new Properties();
			
			try {
				
				prop.load(fi);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}
		
	public String getApplicationUrl() {
		
		String url = prop.getProperty("baseurl");
		return url;
	}

	public String getusername() {
		
		String Username = prop.getProperty("username");
		return Username;
	}
	public String getpassword() {
		
		String Password = prop.getProperty("password");
		return Password;
	}
	
	public String getchromepath() {
		
		String chromepath = prop.getProperty("chrome");
		return chromepath;
	}
	
	public String getfirepath() {
		
		String firepath = prop.getProperty("fireforx");
		return firepath;
	}
	
	public String getiepath() {
		
		String iepath = prop.getProperty("ie");
		return iepath;
	}
}
