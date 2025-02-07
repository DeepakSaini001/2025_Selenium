package org.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager extends DriverManager {

	@Override
	protected WebDriver createDriver() {

		WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		return driver;

	}
}
