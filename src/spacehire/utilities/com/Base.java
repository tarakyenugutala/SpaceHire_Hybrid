package spacehire.utilities.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	public WebDriver driver;
	
	@BeforeClass
	public void preCondition()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.way2automation.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void postCondition()
	{
		driver.close();
	}
	

}
