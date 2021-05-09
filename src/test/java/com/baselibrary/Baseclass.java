package com.baselibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.config.enums.Browsers;
import com.config.enums.OS;
import com.dataproviderUtilities.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	
	public static WebDriver driver=null;
	
	/*public static WebDriver getwebdriver()
	{
		System.out.println("Webdriver is called");
        if (driver == null) {
			
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		    driver=new ChromeDriver();
        	ChromeOptions chromeOptions = new ChromeOptions();
   		 WebDriverManager.chromedriver().setup();
   		 driver = new ChromeDriver(chromeOptions);

		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
        return driver;
	}*/
	
	public static WebDriver selectBrowser(String browser) {
		
		  if (driver == null) {		
			if (browser.equalsIgnoreCase(com.config.enums.Browsers.CHROME.name())) {
				ChromeOptions chromeOptions = new ChromeOptions();
		   		 WebDriverManager.chromedriver().setup();
		   		 driver = new ChromeDriver(chromeOptions);
                 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase(com.config.enums.Browsers.IE.name())) {
				
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				 WebDriverManager.iedriver().setup();
		   		 driver = new InternetExplorerDriver(ieOptions);
                 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		  }
		
	
		return driver;
	}

}
