package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageNegativeTest extends BaseTest {

	@DataProvider
	public Object[][] getWrongCredentials() {
		return new Object[][] { { "abc@123", "abc12345" }, { "@#$^&", "@#!&*^" } };
	}

	@Test(dataProvider = "getWrongCredentials")
	public void doLoginWithWrongCredentialsTest(String email, String password) {
		String errorText = loginPage.doLoginWithWrongCredentials(email, password);
		Assert.assertEquals(errorText, Constants.LOGIN_PAGE_ERROR_MSG);
	}
}
