package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

//	private WebDriver driver;
	private Properties props;
	public static String highlight;
	public OptionsManager optionsManager;

	static ThreadLocal<WebDriver> tlLocalDriver = new ThreadLocal<WebDriver>();

	public WebDriver initialize_driver(Properties props) {

		String browser = props.getProperty("browser").trim();
		highlight = props.getProperty("highlight");
		optionsManager = new OptionsManager(props);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = WebDriverManager.chromedriver().capabilities(optionsManager.getChromeOptions()).create();
			tlLocalDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browser.equals("firefox")) {
//			driver = WebDriverManager.firefoxdriver().create();
			tlLocalDriver.set(WebDriverManager.firefoxdriver().create());
		} else {
			System.out.println("Please enter valid browser name...");
		}
		getThreadLocalDriver().manage().window().fullscreen();
		getThreadLocalDriver().manage().deleteAllCookies();
		getThreadLocalDriver().get(props.getProperty("url").trim());
		return getThreadLocalDriver();
	}

	public static synchronized WebDriver getThreadLocalDriver() {
		return tlLocalDriver.get();
	}

	public Properties initialize_properties() {
		FileInputStream ip;
		props = new Properties();
		String env = System.getProperty("env");
		System.out.println("ENV --- " + env);
		if (env == null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
				props.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			switch (env.toLowerCase()) {
			case "qa":
				try {
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					props.load(ip);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "dev":
				try {
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					props.load(ip);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "stage":
				try {
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					props.load(ip);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "uat":
				try {
					ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
					props.load(ip);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Please enter valid env name...");
				break;
			}
		}

		return props;
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getThreadLocalDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}

}
