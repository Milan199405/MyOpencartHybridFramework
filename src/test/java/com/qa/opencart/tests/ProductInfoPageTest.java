package com.qa.opencart.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoPageSetup() {
		accountPage = loginPage.doLogin(props.getProperty("email").trim(), props.getProperty("password").trim());
	}

//	Product Name - MacBook Pro
//	Brand -  Apple
//	Product Code -  Product 18
//	Reward Points -  800
//	Availability -  In Stock
//	Price - $2,000.00
//	Tax - Ex Tax: $2,000.00

	@Test
	public void getProductMetaDataTest() {
		searchResultsPage = accountPage.doProductSearch("MacBook");
		productInfoPage = searchResultsPage.doProductClick("MacBook Pro");
		Map<String, String> metaData = productInfoPage.getProductInfoMap();
		metaData.forEach((k, v) -> System.out.println(k + " - " + v));
		softAssert.assertEquals(metaData.get("Product Name").trim(), "MacBook Pro");
		softAssert.assertEquals(metaData.get("Brand").trim(), "Apple");
		softAssert.assertEquals(metaData.get("Product Code").trim(), "Product 18");
		softAssert.assertEquals(metaData.get("Reward Points").trim(), "800");
		softAssert.assertEquals(metaData.get("Availability").trim(), "In Stock");
		softAssert.assertEquals(metaData.get("Price").trim(), "$2,000.00");
		softAssert.assertEquals(metaData.get("Tax").trim(), "Ex Tax: $2,000.00");
		softAssert.assertAll();
	}

}
