package org.DriverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;

	protected abstract WebDriver createDriver();

	public WebDriver InitilizeDriver() {

		WebDriver driver = null;
		try {
			// Your driver initialization logic here
			driver = createDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (driver == null) {
			throw new RuntimeException("Driver initialization failed, returned null!");
		}
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null; // Ensure the driver is properly cleaned up
		}
	}

}
/*
 * why abstract -- method overriding, let say you create a abstract class which
 * has abstract method createdriver(){}; then create seperate class for each
 * browser like chrome and firefox and extends it with the abstract class where
 * createdriver method is there and override this with using Webdriver driver=
 * new Chromedriver(); --- with this you are overriding the createdriver()
 * method of abstract class in Chromedriver & firefox class.
 */