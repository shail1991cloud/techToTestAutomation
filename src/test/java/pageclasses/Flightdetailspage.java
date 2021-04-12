package pageclasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class Flightdetailspage {
	WebDriver driver;
	public Flightdetailspage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	@FindBy(how=How.XPATH ,using = "//*[@value='oneway']")
	WebElement oneway;
	@FindBy(how = How.NAME, using = "fromPort")
	WebElement frmport;
	@FindBy(how = How.NAME, using = "fromMonth")	
	WebElement frmmonth;
	@FindBy(how = How.NAME, using = "fromDay")	
	WebElement frmday;
	@FindBy(how=How.XPATH ,using = "//input[@type='radio' and @value='First']")
	WebElement rdbtn;
	@FindBy(how = How.NAME, using = "findFlights")	
	WebElement conclick;

	
	 public void filldetails()
	  {
		 oneway.click();
		 Select selectbyvalue = new Select(frmport);
		 selectbyvalue.selectByValue("London");
		 Select selectbyvalue1 = new Select(frmmonth);
		 selectbyvalue1.selectByIndex(1);
		 Select selectbyvisibletext = new Select(frmday);
		 selectbyvisibletext.selectByVisibleText("8");
		 rdbtn.click();
		 conclick.click();
		 Assert.assertEquals("Select a Flight: Mercury Tours", driver.getTitle());

	  }

}

 