package com.classlibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataprovider.ConfigFileReader;

public class Browserfactory {
	
	
	public static WebDriver driver=null;
	
	public static WebDriver getwebdriver()
	{
		System.out.println("Webdriver is called");
        if (driver == null) {
			
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
        return driver;
	}
	
	

}
