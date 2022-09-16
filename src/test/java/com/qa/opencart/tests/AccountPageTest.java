package com.qa.opencart.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accountPage = loginPage.doLogin(props.getProperty("email").trim(), props.getProperty("password").trim());
	}

	@Test
	public void accountPageTitleTest() {
		String actualTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accountPageContentstest() {
		ArrayList<String> actualContents = accountPage.getPageContents();
		Assert.assertEquals(actualContents, Constants.accountPageContents());
	}

	@DataProvider
	public Object[][] searchData() {
		return new Object[][] { { "MacBook" }, { "Samsung" }, { "Apple" } };
	};

	@Test(priority = 1, dataProvider = "searchData")
	public void productSearchTest(String data) {
		accountPage.doProductSearch(data);
	}

	@Test(priority = 2, dataProvider = "searchData")
	public void imageCountTest(String productName) {
		searchResultsPage = accountPage.doProductSearch(productName);
		int count = searchResultsPage.productImageCount();
		System.out.println(productName + " : " + count);
		Assert.assertTrue(count > 0);
	}
	
	@DataProvider
	public Object[][] products() {
		
		return new Object[][] { 
			
			{ "MacBook", "MacBook Pro" }, 
			{ "Samsung", "Samsung SyncMaster 941BW11" }, 
			{ "Apple", "Apple Cinema 30\"" } 
			
		};
	};
	
	@Test(priority = 3, dataProvider = "products")
	public void doProductClickTest(String baseProduct, String mainProduct) {
		searchResultsPage = accountPage.doProductSearch(baseProduct);
		searchResultsPage.doProductClick(baseProduct);
	}

	@Test
	public void logoutTest() {
		accountPage.doLogout();
	}

}
