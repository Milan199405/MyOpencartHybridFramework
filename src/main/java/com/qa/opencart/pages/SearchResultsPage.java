package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtil elUtil;
	
	private By image = By.xpath("//div[@class = 'image']");
	private By productsName = By.xpath("//div[@class = 'caption']//a");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		elUtil = new ElementUtil(driver);                 
	}
	
	public int productImageCount() {
		return elUtil.doGetElements(image).size();
	}
	
	public ProductInfoPage doProductClick(String actualProductName) {
	 List<WebElement> nameList = elUtil.doGetElements(productsName);
	 for(WebElement e: nameList) {
		 String nameText = e.getText();
		 if(nameText.equals(actualProductName)) {
			 e.click();
			 break;
		 }
	 }
	 
	 return new ProductInfoPage(driver);
	}
}
