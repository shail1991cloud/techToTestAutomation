package com.managersUtilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;

public class Commonfunction {
	

	public static void commom(WebDriver driver)
	
	{
		driver.manage().window().maximize();
		
	}
	
public static void commoms1(WebDriver driver)
	
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
		
	}

public static void waitForElementToAppear(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public static void getScreenShots(WebDriver driver,Scenario scenario) throws IOException

{
	if (scenario.isFailed()) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			//This takes a screenshot from the driver at save it to the specified location
			TakesScreenshot ts= (TakesScreenshot)driver;
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);
			
			//Building up the destination path for the screenshot to save
			//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
			Date d = new Date();
			Timestamp t = new Timestamp(d.getTime());
			String timeStamp = t.toString();
			timeStamp = timeStamp.replace(' ', '_');
			timeStamp = timeStamp.replace(':', '_');
			
			String dest = System.getProperty("user.dir")+"/target/ScreenShots/failscreen"+ timeStamp +".png";
			System.out.println(dest);
			File destinationPath = new File(dest); 
			
			//Copy taken screenshot from source location to destination location
			Files.copy(sourcePath, destinationPath);   

			//This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
		} 
	}
	
	
}


}
