package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.classlibrary.Browserfactory;
import com.classlibrary.Commonfunction;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageclasses.Loginpage;
import pageclasses.Selectflight;
import com.cucumber.listener.Reporter;
import org.openqa.selenium.OutputType;
import com.google.common.io.Files;

public class Steps {
	
	
	WebDriver driver;
	Loginpage lpf;
	Selectflight slf;
    public ConfigFileReader configFileReader;
    
    
    public Steps()
    {
    	driver = Browserfactory.getwebdriver();
		lpf=PageFactory.initElements(driver,Loginpage.class);
		slf=PageFactory.initElements(driver,Selectflight.class);
		configFileReader=new ConfigFileReader();
    }
	
    @Before
    public void beforeScenario(Scenario scenario) {
        Reporter.assignAuthor("Shailendra Parihar");
    }

	@Given("^user is on login page$")
	public void when_user_launches()  {
		
		
		 driver.get(configFileReader.getApplicationUrl());
		 Commonfunction.commom(driver);
		
	     
		
	}
	@When("^enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_and(String username, String password) throws Throwable {
	    lpf.login(username, password);
	    Reporter.addStepLog("Login name is entered");
	}

	@Then("^he is able to validate \"([^\"]*)\"$")
	public void he_is_able_to_validate(String arg1) throws Throwable {
	  slf.validateFlightDetailsTag();
	  Reporter.addStepLog("Tag is verified");
	}
	

		@After(order = 1)
		public void afterScenario(Scenario scenario) throws IOException {
			
			Commonfunction.getScreenShots(driver, scenario);
	
		}
	
	
	@After(order = 0)
    public void afterScenario(){
		Reporter.addScenarioLog("----Test is Completed----");
        driver.quit();
    }

}
