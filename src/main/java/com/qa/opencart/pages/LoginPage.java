package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elUtil;

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By submit = By.xpath("//input[@type = 'submit']");
	private By errorText = By.xpath("//div[@class = 'alert alert-danger alert-dismissible']");
	private By register = By.cssSelector("aside#column-right a:nth-of-type(2)");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elUtil = new ElementUtil(driver);
	}

	public String getLoginPageUrl() {
		return elUtil.doGetUrl();
	}

	public String getLoginPageTitle() {
		return elUtil.doGetTitle();
	}

	public AccountPage doLogin(String email, String password) {
		elUtil.doSendKeys(this.email,email);
		elUtil.doSendKeys(this.password,password);
        elUtil.doClick(submit);
        return new AccountPage(driver);
	}
	
	public String doLoginWithWrongCredentials(String email, String password) {
		elUtil.doSendKeys(this.email,email);
		elUtil.doSendKeys(this.password,password);
        elUtil.doClick(submit);
        return elUtil.doGetText(errorText);
	}
	
	public RegisterPage clickOnRegister() {
		elUtil.doClick(register);
		return new RegisterPage(driver);
	}
}
