package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties props;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionsManager(Properties props) {
		this.props = props;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		String headless = props.getProperty("headless");
		if (Boolean.parseBoolean(headless)) co.setHeadless(true);
		
		String incognito = props.getProperty("incognito");
		if (Boolean.parseBoolean(incognito)) co.addArguments("--incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		String headless = props.getProperty("headless");
		if (Boolean.parseBoolean(headless)) {
			fo.addArguments("--headless");
		}

		String incognito = props.getProperty("incognito");
		if (Boolean.parseBoolean(incognito)) {
			fo.addArguments("--incognito");
		}
		return fo;
	}
}
