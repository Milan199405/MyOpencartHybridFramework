package com.qa.opencart.utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;

public class UrlUtil {
	private WebDriver driver;

	public UrlUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl(String url) {
		try {
			if (url == null)
				throw new Exception("url is null");

		} catch (Exception e) {

		}
		driver.get(url);
	}

	public void openUrl(URL url) {
		try {
			if (url == null)
				throw new Exception("URL is null");

		} catch (Exception e) {

		}
		driver.navigate().to(url);
	}

	public void openUrl(String baseUrl, String path) {
		try {
			if (baseUrl == null)
				throw new Exception("Base url is null");

		} catch (Exception e) {

		}
		driver.get(baseUrl + "/" + path);
	}

	public void openUrl(String baseUrl, String path, String queryParam) {
		try {
			if (baseUrl == null)
				throw new Exception("Base url is null");

		} catch (Exception e) {

		}
		driver.get(baseUrl + "/" + "?" + queryParam);
	}

}
