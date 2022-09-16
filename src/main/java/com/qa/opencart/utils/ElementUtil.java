package com.qa.opencart.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtil jse;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jse = new JavaScriptUtil(driver);
	}

	public String doGetUrl() {
		return driver.getCurrentUrl();
	}

	public String doGetTitle() {
		return driver.getTitle();
	}

	public WebElement doGetElement(By locator) {
		WebElement element = driver.findElement(locator);
		String highlight = DriverFactory.highlight;
    	if (Boolean.parseBoolean(highlight)) {
			jse.flash(element);
			return element;
		}
		return element;
	}

	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}

	public List<WebElement> doGetElementsWithWait(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void doClear(By locator) {
		doGetElement(locator).clear();
	}

	public void doSendKeys(By locator, String keys) {
		doClear(locator);
		doGetElement(locator).sendKeys(keys);
	}

	public void doClick(By locator) {
		doGetElement(locator).click();
	}
	
	public void doClickWithWait(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}

}
