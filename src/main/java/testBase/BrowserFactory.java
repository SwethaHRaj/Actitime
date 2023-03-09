package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	WebDriver driver;
	public WebDriver createBrowserInstance(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions option=new ChromeOptions();
	 		option.addArguments("--incognito");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firfox")) {
			FirefoxOptions option=new FirefoxOptions();
			option.addArguments("-private");		//check
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(option);
		}
		else if(browser.equalsIgnoreCase("msedge")) {
			EdgeOptions option=new EdgeOptions();
			option.addArguments("-private");		//check
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(option);
		}
		else if(browser.equalsIgnoreCase("ie")) {
			InternetExplorerOptions option=new InternetExplorerOptions();
			option.addCommandSwitches("-private");		//check
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver(option);
		}
		return driver;
	}
	
	

}
