package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import testBase.BaseClass;
import testBase.WebDriverFactory;

public class ManageDepartmentsPageObjects extends BaseClass{
	
	By text_newDepartmentName= By.id("groupManagementLightBox_newGroupInput");
	By btn_add=By.id("groupManagementLightBox_addGroupButton");
	By error_errorMessage=By.id("groupManagementLightBox_bottomErrorMessageText");
	By btn_close=By.id("groupManagementLightBox_closeLightbox");
	
	public void createDepartmentAndValidate(String departmentName) throws Exception {
		WebElement we1=WebDriverFactory.getInstance().getWebDriver().findElement(text_newDepartmentName);
		sendKeys_Custom(we1, "New Department Name Text field", departmentName);
		WebElement we2=WebDriverFactory.getInstance().getWebDriver().findElement(btn_add);
		click_Custom(we2, "Add button of Manage Departments page");
		String b=WebDriverFactory.getInstance().getWebDriver().findElement(error_errorMessage).getText();
		/*if(b.equalsIgnoreCase("Department with the specified name already exists"))
			Assert.fail("Error msg displayed--->Department with the specified name already exists");
		else {
			WebElement department=WebDriverFactory.getInstance().getWebDriver().findElement(By.xpath("//table/tr/td/div/div[1][text()='"+departmentName+"']"));
			Assert.assertTrue(isElementPresent_Custom(department, "Create Department validation in Departments List"));
			WebElement close=WebDriverFactory.getInstance().getWebDriver().findElement(btn_close);
			click_Custom(close, "Close button");
		}*/
		
	

	}
}
	
