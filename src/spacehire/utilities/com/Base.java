package spacehire.utilities.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public static WebDriver driver;
	
	
	public void OpenBrowser(String url)
	{
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	public static void implicitWait(long waitTime){
		//polling time is 250ms
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	public static void explicitWait(long waitTime, By locator){
		//polling time is 500 ms
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void mouseHover()
	{
		
	}

}
