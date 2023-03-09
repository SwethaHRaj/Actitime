package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import reusableComponents.ActionEngine;
import reusableComponents.PropertiesOperation;

public class BaseClass extends ActionEngine{
	
	
	BrowserFactory bf=new BrowserFactory();
	
	@BeforeMethod
	public void launchBrowser() throws Exception {
		
		WebDriverFactory.getInstance().setWebDriverInstance(bf.createBrowserInstance(PropertiesOperation.getPropertyDataByKey("browser")));
		WebDriver driver=WebDriverFactory.getInstance().getWebDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(PropertiesOperation.getPropertyDataByKey("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {	
		WebDriverFactory.getInstance().closeBrowser();
	}

}
