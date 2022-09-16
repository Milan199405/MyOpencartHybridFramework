package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.utils.Constants;

@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageUrl();
		Assert.assertEquals(actualUrl, Constants.LOGIN_PAGE_URL);
	}
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 1)
	public void loginTest() {
	accountPage = loginPage.doLogin(props.getProperty("email").trim(), props.getProperty("password").trim());
	String accountPageActualTitle = accountPage.getAccountPageTitle();
	System.out.println(accountPageActualTitle);
	Assert.assertEquals(accountPageActualTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
}
