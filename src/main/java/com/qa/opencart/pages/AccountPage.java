package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil elUtil;
	
	private By searchField = By.xpath("//input[@name = 'search']");
	private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	private By pageContent = By.xpath("//div[@id = 'content']//h2");
	private By logout = By.xpath("(//a[text() = 'Logout'])[2]");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		return elUtil.doGetTitle();
	}
	
	public  ArrayList<String> getPageContents() {
	    ArrayList<String> pageContents = new ArrayList<String>();
		List<WebElement> pageContentList = elUtil.doGetElementsWithWait(pageContent, Constants.DEFAULT_TIMEOUT);
		for(WebElement e: pageContentList) {
			String text = e.getText();
			pageContents.add(text);
		}
		return pageContents;
		
	}
	
	public SearchResultsPage doProductSearch(String productName) {
		elUtil.doSendKeys(searchField, productName);
		elUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}
	
	public void doLogout() {
		elUtil.doClick(logout);
	}
}
