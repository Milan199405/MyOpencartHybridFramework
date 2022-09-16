package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

//	private WebDriver driver;
	private ElementUtil elUtil;

	private By productHeader = By.tagName("h1");
	private By productMetaData = By.xpath("(//h1//following-sibling::ul)[1]/li");
	private By productPriceData = By.xpath("(//h1//following-sibling::ul)[2]/li");

	Map<String, String> metaData;

	public ProductInfoPage(WebDriver driver) {
//		this.driver = driver;
		elUtil = new ElementUtil(driver);
	}

	public Map<String, String> getProductInfoMap() {
		metaData = new LinkedHashMap<String, String>();
		metaData.put("Product Name",  getProductHeader());
		productMetaData();
		productPriceData();
		return metaData;
	}
	
	public String getProductHeader() {
		return elUtil.doGetText(productHeader);
	}

//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock

	private void productMetaData() {
		List<WebElement> metaList = elUtil.doGetElements(productMetaData);
		for (WebElement e : metaList) {
			String text = e.getText();
			String splittedText[] = text.split(":");
			String key = splittedText[0];
			String value = splittedText[1];
            metaData.put(key, value);
		}
	}
	
	
//	$2,000.00
//	Ex Tax: $2,000.00

	private void productPriceData() {
		List<WebElement> priceList = elUtil.doGetElements(productPriceData);
		String price = priceList.get(0).getText();
		String tax = priceList.get(1).getText();
		metaData.put("Price", price);
		metaData.put("Tax", tax);
	}
}
