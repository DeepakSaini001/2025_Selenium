package org.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomAssert {
	protected static Logger log = LogUtils.getLogger();

	public static final void assertTextEquals(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual, expected, message);
			System.out.println("Assertion passed: " + message);
			log.info("Assertion passed: " + message);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + message + " - " + e.getMessage());
			log.info("Assertion failed: " + message);
			throw e;
		}
	}

	public static final void assertElementIsDisplayed(boolean isDisplayed, String message) {
		try {
			Assert.assertTrue(isDisplayed, message);
			System.out.println("Assertion passed: " + message);
			log.info("Assertion passed: " + message);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + message + " - " + e.getMessage());
			log.info("Assertion failed: " + message);
			throw e;
		}
	}

	public static final void assertContainsText(String actual, String expectedSubstring, String message) {
		try {
			Assert.assertTrue(actual.contains(expectedSubstring), message);
			System.out.println("Assertion passed: " + message);
			log.info("Assertion passed: " + message);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + message + " - " + e.getMessage());
			log.info("Assertion failed: " + message);
			throw e;
		}
	}

	public static final void assertElementDisplayed(WebElement element, String message) {
		try {
			Assert.assertTrue(element.isDisplayed(), message);
			System.out.println("Assertion passed: " + message);
			log.info("Assertion passed: " + message);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + message + " - " + e.getMessage());
			log.info("Assertion failed: " + message);
			throw e;
		}

	}


}
