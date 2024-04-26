package utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BasePage {

	protected WebDriver driver;


	public BasePage() {

		String chromedriverPath = System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe";        
		// Set the system property
		System.setProperty("webdriver.chrome.driver", chromedriverPath);

		// Construct the path to Chromedriver executable

		// String chromeDriverPath = System.getProperty("/src/main/resources/chromedriver.exe");

		// // Set Chromedriver path

		// System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		// Initialize ChromeDriver

		this.driver = new ChromeDriver();


	}

	public WebDriver getDriver() {

		return driver;

	}

}
