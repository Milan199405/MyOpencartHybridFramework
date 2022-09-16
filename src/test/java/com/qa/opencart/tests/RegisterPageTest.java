package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerPageSetup() {
		registerPage = loginPage.clickOnRegister();
	}

	public String getRandomEmail() {
		Random random = new Random();
		String email = "demoEmail" + random.nextInt(10000) + "@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] registerData() {
		Object testData[][] = ExcelUtil.getTestDataFromExcelSheet(Constants.REGISTER_SHEET_NAME);
		return testData;
	}

	@Test(dataProvider = "registerData")
	public void registerTest(String fn, String ln, String mobile, String pwd, String subscribe) {
		Assert.assertTrue(registerPage.registerAccount(fn, ln, getRandomEmail(), mobile, pwd, subscribe));
	}
}
