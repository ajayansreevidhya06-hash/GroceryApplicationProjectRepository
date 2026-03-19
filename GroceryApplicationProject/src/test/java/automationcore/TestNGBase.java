package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenShotUtility;

public class TestNGBase {

	
public WebDriver driver;////WebDriver declaration ->WebDriver is a predefined interface
	
	@BeforeMethod
	public void browserLaunch()
	{
		driver=new ChromeDriver(); ////WebDriver Initialization
		//driver=new FirefoxDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

  //driver.close();
	}	
		
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
  
 			ScreenShotUtility screenShot = new ScreenShotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName()); 
 		} 
 		//driver.quit(); 
  
 	}

}
