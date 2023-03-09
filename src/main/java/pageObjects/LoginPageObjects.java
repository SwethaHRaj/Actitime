package pageObjects;

import org.openqa.selenium.By;

import testBase.BaseClass;
import testBase.WebDriverFactory;

public class LoginPageObjects extends BaseClass{
	
	By tb_username=By.id("username");
	By tb_password=By.name("pwd");
	By btn_login=By.id("loginButton");
	
	public void login(String un,String pwd) {
		sendKeys_Custom(WebDriverFactory.getInstance().getWebDriver().findElement(tb_username), "Username",un);
		sendKeys_Custom(WebDriverFactory.getInstance().getWebDriver().findElement(tb_password), "Password",pwd);
		click_Custom(WebDriverFactory.getInstance().getWebDriver().findElement(btn_login), "LoginButton");
	}
	
}
