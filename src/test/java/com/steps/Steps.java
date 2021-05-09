package com.steps;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.baselibrary.Baseclass;
import com.cucumber.listener.Reporter;
import com.dataproviderUtilities.ConfigFileReader;
import com.helperUtilities.LoggerHelper;
import com.managersUtilities.Commonfunction;
import com.pagesPF.Loginpage;
import com.pagesPF.Selectflight;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends Baseclass {
	
	
	
	Loginpage lpf;
	Selectflight slf;
    public ConfigFileReader configFileReader;
    Logger log = LoggerHelper.getLogger(Steps.class);
    
    public Steps()
    {
    	//driver = Browserfactory.getwebdriver();
    //	driver = Browserfactory.selectBrowser("CHROME");
		lpf=PageFactory.initElements(driver,Loginpage.class);
		slf=PageFactory.initElements(driver,Selectflight.class);
		configFileReader=new ConfigFileReader();
		
		
		
    }
	


	@Then("^he is able to validate \"([^\"]*)\"$")
	public void he_is_able_to_validate(String arg1) throws Throwable {
	  configFileReader.getImplicitlyWait();	
	  slf.validateFlightDetailsTag();
	  Reporter.addStepLog("Tag is verified");
	   log.info("---Verifying----");
	}
	


}
