package org.Base;

import java.time.Duration;

import org.Listeners.Test_Listener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.utils.LogUtils;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class BasePage {

	protected WebDriver driver; // these are the instance variable which is non static
	protected WebDriverWait wait;
	protected SoftAssert softAssert;
	protected static Logger log = LogUtils.getLogger();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		softAssert = new SoftAssert();

	}

	public void navigateToURL(String endPoint) {
		driver.get("https://www.myprotein.co.in/" + endPoint);
		log.info("Navigating to URL Successfully" + " : " + driver.getCurrentUrl());
	}

	public void click(WebElement element, String elementName) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void sendKeys() {

	}

}
