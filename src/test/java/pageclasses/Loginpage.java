package pageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class Loginpage {
	
	WebDriver driver;
	public Loginpage(WebDriver driver)
	{
	this.driver=driver;
	} 
	@FindBy(how=How.XPATH ,using = "//input[@type='text' and @name='userName']")
	WebElement uname;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement pwd;
	@FindBy(how = How.XPATH, using = "//td[2]/div/input[@type='submit']")	
	WebElement submit;
	
	public void login(String userid,String password) throws InterruptedException
	{
		uname.clear();
		uname.sendKeys(userid);
		pwd.clear();
		pwd.sendKeys(password);
		submit.click();
		Thread.sleep(4000);
		
		
	}

}
