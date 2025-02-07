package org.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager_original {
	
	public WebDriver InitializeDriver() {
	//	System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		// ChromeOptions options = new ChromeOptions();
	      //  options.addArguments("--blink-settings=imagesEnabled=false");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		return driver; 
		
	}

}
