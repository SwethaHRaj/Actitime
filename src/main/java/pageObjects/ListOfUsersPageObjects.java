package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.BaseClass;
import testBase.WebDriverFactory;

public class ListOfUsersPageObjects extends BaseClass{
	
	By btn_departments=By.xpath("//table/tbody/tr/td/div/div/div[text()='  Departments']");
	By btn_newUser=By.xpath("//table/tbody/tr/td/div/div/div[text()='New User']");
	By btn_bulkInvitations=By.xpath("//table/tbody/tr/td/div/div/div[text()='Bulk Invitations']");
	
	public void checkListOfUsersPageNavigation() {
		WebElement we=WebDriverFactory.getInstance().getWebDriver().findElement(btn_departments);
		isElementPresent_Custom(we, "List Of Users Page");		
	}
	
	public void clickOnButton(String button) throws Exception {
		WebElement we;
		if(button.contentEquals("Departments")) 
			we=WebDriverFactory.getInstance().getWebDriver().findElement(By.xpath("//table/tbody/tr/td/div/div/div[text()='  Departments']"));
		else if(button.equalsIgnoreCase("New User")||button.equalsIgnoreCase("New User"))
			we=WebDriverFactory.getInstance().getWebDriver().findElement(By.xpath("//table/tbody/tr/td/div/div/div[text()='"+button+"']"));
		else
			throw new Exception(button +" not valid");
		click_Custom(we, "Departments Button");
	}

}
