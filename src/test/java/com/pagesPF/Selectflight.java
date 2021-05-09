package com.pagesPF;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.managersUtilities.Commonfunction;

public class Selectflight {
	WebDriver driver;
	
	public Selectflight(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH ,using = "//td[2]/a[text()='Flights']")
	WebElement flightTag;

	@FindBy(how = How.XPATH, using = "//font/font[contains(text(),'Flight')]")	
	WebElement flightDetailsTag;
	
	public void validateFlightDetailsTag()
	{
		Commonfunction.waitForElementToAppear(driver,flightTag);
		flightTag.click();
		Commonfunction.waitForElementToAppear(driver,flightDetailsTag);
		Assert.assertTrue(!flightDetailsTag.isDisplayed());
		
	}
}
