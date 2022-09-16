package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
//	private WebDriver driver;
	private ElementUtil elUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class = 'radio-inline'])[1]");
	private By subscribeNo = By.xpath("(//label[@class = 'radio-inline'])[2]");
	private By privacyPolicy = By.xpath("//input[@name = 'agree']");
	private By continueBtn = By.xpath("//input[@value = 'Continue']");
	private By successMsg = By.cssSelector("div#content h1");
	private By logout = By.xpath("//aside[@id = 'column-right']//a[text() = 'Logout']");
	private By register = By.xpath("(//a[text() = 'Register'])[2]");

	public RegisterPage(WebDriver driver) {
//		this.driver = driver;
		this.elUtil = new ElementUtil(driver);
	}

	public Boolean registerAccount(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {

		elUtil.doSendKeys(this.firstName, firstName);
		elUtil.doSendKeys(this.lastName, lastName);
		elUtil.doSendKeys(this.email, email);
		elUtil.doSendKeys(this.telephone, telephone);
		elUtil.doSendKeys(this.password, password);
		elUtil.doSendKeys(this.confirmPassword, password);
		if(subscribe.equalsIgnoreCase("yes")) {
			elUtil.doClick(this.subscribeYes);	
		} else {
			elUtil.doClick(this.subscribeNo);
		}

		elUtil.doClick(this.privacyPolicy);
		elUtil.doClick(this.continueBtn);
		String message = elUtil.doGetText(successMsg);
		elUtil.doClickWithWait(logout, Constants.DEFAULT_TIMEOUT);
		elUtil.doClick(register);
		if(message.equals(Constants.ACCOUNT_CREATION_SUCCESS_MSG)) {
			return true;
		}else {
			return false;
		}
	}
}
