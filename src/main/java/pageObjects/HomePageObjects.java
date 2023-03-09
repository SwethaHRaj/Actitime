package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import testBase.BaseClass;
import testBase.WebDriverFactory;

public class HomePageObjects extends BaseClass{
	
	WebDriver driver;
	
	By menu_timeTrack=By.xpath("//table[@id='topnav']/tbody/tr/td/a/div[1][text()='Time-Track']"); //delete unwanted
	By menu_tasks=By.xpath("//table[@id='topnav']/tbody/tr/td/a/div[1][text()='Tasks']");
	By menu_reports=By.xpath("//table[@id='topnav']/tbody/tr/td/a/div[1][text()='Reports']");
	By menu_users=By.xpath("//table[@id='topnav']/tbody/tr/td/a/div[1][text()='Users']");
	By subMenu_enterTimeTrack=By.xpath("//table/tbody/tr[@class='secondLevelRow']/td[2]/div/a[text()='Enter Time-Track']");
	By subMenu_viewTimeTrack=By.xpath("//table/tbody/tr[@class='secondLevelRow']/td[2]/div/a[text()='View Time-Track']");
	By subMenu_lockTimeTrack=By.xpath("//table/tbody/tr[@class='secondLevelRow']/td[2]/div/a[text()='Lock Time-Track']");
	By subMenu_approveTimeTrack=By.xpath("//table/tbody/tr[@class='secondLevelRow']/td[2]/div/a[text()='Approve Time-Track']");
	By link_logout=By.xpath("logoutLink");
	
	public void clickOnMenu(String mainMenu) {
		String mainMenuOption="//table[@id='topnav']/tbody/tr/td/a/div[1][text()='"+mainMenu+"']";
		WebDriverFactory.getInstance().getWebDriver().findElement(By.xpath(mainMenuOption)).click();
	}
	
	public void clickOnSubmenu(String subMenu) {
		String subMenuOption="//table/tbody/tr[@class='secondLevelRow']/td[2]/div/a[text()='"+subMenu+"']";
		WebDriverFactory.getInstance().getWebDriver().findElement(By.xpath(subMenuOption));
	}
	
	public void checkHomePageNavigation() {
		WebElement we=WebDriverFactory.getInstance().getWebDriver().findElement(link_logout);
		Assert.assertTrue(isElementPresent_Custom(we, "logoutLink"));
	}
	
	


}
