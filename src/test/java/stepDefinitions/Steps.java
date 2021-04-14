package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.classlibrary.Browserfactory;
import com.classlibrary.Commonfunction;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.ConfigFileReader;
import helper.LoggerHelper;
import pageclasses.Loginpage;
import pageclasses.Selectflight;

public class Steps {
	
	
	WebDriver driver;
	Loginpage lpf;
	Selectflight slf;
    public ConfigFileReader configFileReader;
    Logger log = LoggerHelper.getLogger(Steps.class);
    
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
        log.info("---Starting the Run----");
        
    }

	@Given("^user is on login page$")
	public void when_user_launches()  {
		
		
		 driver.get(configFileReader.getApplicationUrl());
		 Commonfunction.commom(driver);
		   log.info("---Launching the Browser----");
		
	     
		
	}
	@When("^enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_and(String username, String password) throws Throwable {
	    lpf.login(username, password);
	    Reporter.addStepLog("Login name is entered");
	    log.info("---Logging In----");
	}

	@Then("^he is able to validate \"([^\"]*)\"$")
	public void he_is_able_to_validate(String arg1) throws Throwable {
	  slf.validateFlightDetailsTag();
	  Reporter.addStepLog("Tag is verified");
	   log.info("---Verifying----");
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
