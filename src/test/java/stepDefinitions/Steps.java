package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import dataprovider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	
	ConfigFileReader configFileReader;
	
	public Steps()
	
	{
		configFileReader= new ConfigFileReader();
	}
	
	
	
	@Given("^when user launches$")
	public void when_user_launches()  {
		ChromeOptions chromeOptions = new ChromeOptions();
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver(chromeOptions);
	
		 driver.get(configFileReader.getApplicationUrl());
		 
		 driver.quit();
	}

}
