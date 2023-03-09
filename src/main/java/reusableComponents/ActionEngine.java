package reusableComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testBase.ExtentFactory;
import testBase.WebDriverFactory;

public class ActionEngine {
	
	
	//customized send keys method ---> to log sendKeys messages to every occurrence
	public void sendKeys_Custom(WebElement element, String fieldName, String valueToSend) {
		try {
			element.sendKeys(valueToSend);
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldName+" Entered value as "+valueToSend);
		}
		catch(Exception e){
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, fieldName+" Entered value as "+valueToSend+" failed due to Exception "+e);
		}	
	}
	
	public void click_Custom(WebElement element, String fieldName) {
		try {
			element.click();
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldName+"---> Clicked succesfully");
		}
		catch(Exception e){
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL,"Unable to click "+ fieldName+ "---> failed due to Exception "+e);
		}
	}
	
	public void clear(WebElement element, String fieldName) {
		try {
			element.clear();
			//Thread.sleep(2000);
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldName+"---> Cleared succesfully");
		}
		catch(Exception e){
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL,"Unable to clear "+ fieldName+ "---> failed due to Exception "+e);
		}
	}
	
	public void moveToElement_custom(WebElement element, String fieldName) {
		try {
			JavascriptExecutor j=(JavascriptExecutor) WebDriverFactory.getInstance().getWebDriver();
			j.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions a=new Actions(WebDriverFactory.getInstance().getWebDriver());	//??
			a.moveToElement(element).build().perform();	//??
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldName+"---> mouse hovered successfully");
			Thread.sleep(2000);			
		}
		catch(Exception e){
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL,"Unable to move to "+ fieldName+ "---> failed due to Exception "+e);
		}
	}
	
	public boolean isElementPresent_Custom(WebElement element, String fieldName) {
		boolean flag=false;
		try {
			flag=element.isDisplayed();
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, fieldName+"---> presence is "+flag);
			return flag;
		}
		catch(Exception e){
			ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, fieldName+ "---> failed due to Exception "+e);
			return flag;
		}
	}
	
	public void asertEqualsString_custom(String expectedValue, String actualValue, String fieldName) {
		try {
			Assert.assertEquals(expectedValue, actualValue);
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS,"String Assertion successful for field "+fieldName+" Expected value was"+expectedValue);
		}catch(Exception e) {
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS,"String Assertion failed for field "+fieldName+" Expected value was"+expectedValue);
		}
	}
	
	public String getText_Custom(WebElement element, String fieldName) {
		String text=null;
		try {
			text=element.getText();
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "Text retrieved for "+fieldName+" is "+text);
			return text;
		}catch (Exception e) {
			ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "Text not retrieved for "+fieldName+" due to exception "+e);
			return text;
		}
	}
	
}















