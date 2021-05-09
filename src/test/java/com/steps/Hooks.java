package com.steps;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.baselibrary.Baseclass;
import com.config.enums.Browsers;
import com.cucumber.listener.Reporter;
import com.dataproviderUtilities.ConfigFileReader;
import com.helperUtilities.LoggerHelper;
import com.managersUtilities.Commonfunction;
import com.pagesPF.Loginpage;
import com.pagesPF.Selectflight;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	WebDriver driver;
	Loginpage lpf;
	Selectflight slf;
    public ConfigFileReader configFileReader;
    Logger log = LoggerHelper.getLogger(Steps.class);
    
    public Hooks()
    {
    	driver = Baseclass.selectBrowser(Browsers.CHROME.name());
    	//driver = Browserfactory.getwebdriver();
		configFileReader=new ConfigFileReader();	
		
    }
    @Before
    public void beforeScenario(Scenario scenario) {
        Reporter.assignAuthor("Shailendra Parihar");
        log.info("---Starting the Run----");
        
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
