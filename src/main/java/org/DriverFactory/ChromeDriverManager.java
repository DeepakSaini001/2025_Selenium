package org.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	public WebDriver createDriver() {

		WebDriverManager.chromedriver().cachePath("Drivers").setup();
		driver = new ChromeDriver(); // local driver object
		driver.manage().window().maximize();

		return driver;
	}

}
/*
 * this createDriver method creates because we have extends the DriverManager
 * class here, and inside DriverManager there is one abstract method called
 * createDriver. so when by the time we extends DriverManager class into
 * ChromeDriverManager then ChromeDriverManager class will gives error stating
 * add unimplemented methods. concept of abstraction and interface
 */
