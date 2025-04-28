package testScript;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	FileInputStream fileinput;
	Properties properties;
	public WebDriver driver;
  
  @BeforeMethod(alwaysRun=true)
  @Parameters("browser")
  public void initializeBrowser(String browser) throws Exception {
	  properties = new Properties();
	  fileinput = new FileInputStream(Constants.CONFIGFILE);
	  properties.load(fileinput);//called url and url is loaded here
	  
	  if(browser.equalsIgnoreCase("Chrome")) {
		  driver= new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("Edge")) {
		  driver = new EdgeDriver();
	  }
	  else if(browser.equalsIgnoreCase("Firefox")) {
		  driver = new FirefoxDriver();
	  }
	  else 
	  {
		  throw new Exception("Invalid Browser");
	  }
	  
		  
	  
	  
	  driver.get(properties.getProperty("url"));
	  driver.manage().window().maximize();
	  WaitUtilities waitutility = new WaitUtilities();
	  waitutility.implicitWait(driver);
  }

  @AfterMethod(alwaysRun=true)
  
  public void browserQuit(ITestResult itestresult) throws IOException {
	  if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtility screenshot =new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
	  driver.quit();
  }

}
