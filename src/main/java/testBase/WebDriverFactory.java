package testBase;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	private static WebDriverFactory instance=new WebDriverFactory();
	
	//constructor making private to have singleton class concept
	private WebDriverFactory() {
	}
	
	//method to get instance of singleton class to have global access
	public static WebDriverFactory getInstance () {
		return instance;
	}
	
	/*factory design pattern=defining separate factory methods
	for creating objects and create the objects by calling those methods*/
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public void setWebDriverInstance(WebDriver testDriver) {
		this.driver.set(testDriver);
	}
	
	public WebDriver getWebDriver() {
		return this.driver.get();
	}
	
	public void closeBrowser() {
		this.driver.get().close();
		this.driver.remove();
	}
}
