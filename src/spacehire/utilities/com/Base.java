package spacehire.utilities.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.driver")+"E:\\Eclipse workbench\\SpcehireFrameWork\\browsers");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user,driver")+"E:\\Eclipse workbench\\SpcehireFrameWork\\browsers");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	/*public void OpenBrowser(String url)
	{
		driver = new FirefoxDriver();
		driver.get(url);
	}*/
	
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
		WebElement actionElement = null;
		Actions action = new Actions(driver);
		action.moveToElement(actionElement);
		action.perform();
	}
	
	public static void wait(String wait)
	{
		Object implicitWait = null;
		if(wait.equals(implicitWait))
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		{
			WebElement locator = null;
			WebDriverWait waits = new WebDriverWait(driver, 20);
			waits.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
		}
		
			
	}
	
	public static void logIn()
	{
		
	}
	public static void logOut()
	{
		
	}
	public static void bookNow()
	{
		driver.findElement(By.xpath("//*[@id='booknow']")).click();
	}
	public static void checkOut()
	{
		driver.findElement(By.xpath("//*[@id='checkout']")).click();
	}
	public static void applyCouponCode(String couponcode)
	{
		driver.findElement(By.xpath("//*[@class='discount-coupon-code form-control']")).sendKeys(couponcode);
		driver.findElement(By.xpath("//*[@id='BookingAvailableController']/form/div[3]/div[1]/div/div/div[3]/span/input")).click();
		
	}
	

}
