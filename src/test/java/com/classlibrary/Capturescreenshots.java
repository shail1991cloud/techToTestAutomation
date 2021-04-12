package com.classlibrary;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Capturescreenshots {

	
	public static String capturescreenshots(WebDriver driver, String screenshotName) throws IOException
	
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		String timeStamp = t.toString();
		timeStamp = timeStamp.replace(' ', '_');
		timeStamp = timeStamp.replace(':', '_');
		String dest = ".//ScreenShots//" + screenshotName + "_" + timeStamp + ".png";
		File destFile = new File(dest);  
		FileUtils.copyFile(Source, destFile);
	
		return dest;
		
		
	}
	
	
	
}
