package org.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.Constants.DriverType;
import org.DriverFactory.DriverManagerFactory;
import org.DriverFactory.DriverManager_original;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.utils.ExtentReporterNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BaseTest_Without_Extent {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected ExtentReports extent;
	protected ExtentTest test;
	

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);

	}

	public WebDriver getDriver() {
		return this.driver.get();

	}

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		extent = ExtentReporterNG.getInstance(); // Initialize Extent Reports
	}

	@BeforeMethod
	public void startDriver(@Optional String browser, ITestResult result) {
		// setDriver(new DriverManager_original().InitializeDriver());
		browser = System.getProperty("broswer", browser);

		if (browser == null || browser.isEmpty()) {
			browser = "CHROME";
		}
		try {
			setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser.toUpperCase())).InitilizeDriver());
			// setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
			System.out.println("Current thread" + Thread.currentThread().getId() + ", " + "Driver" + " startDriver : "
					+ getDriver());
			test = extent.createTest(result.getMethod().getMethodName());
		System.out.println("ExtentTest created: " + test.getModel().getName());
		} catch (Exception e) {
			e.printStackTrace();
			 throw new RuntimeException("Driver initialization failed!");
		}

	}

	@AfterMethod
	public void quitDriver(@Optional String browser, ITestResult result) throws IOException {
		System.out.println(
				"Current thread" + Thread.currentThread().getId() + ", " + "Driver" + " quitDriver : " + getDriver());
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File destinationFile = new File("ScreenShot" + File.separator + browser + File.separator
					+ result.getTestClass().getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName()
					+ "_" + timestamp + ".png");
			takeScreenshot(destinationFile);
			test.log(Status.FAIL, "Test Failed: " + result.getThrowable())
					.addScreenCaptureFromPath(destinationFile.getAbsolutePath());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
		}
		if (getDriver() != null) {
			getDriver().quit(); // Close the WebDriver instance
		}
		
		extent.flush(); // Flush ExtentReports after each test
	}

	private void takeScreenshot(File destinationFile) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot) getDriver());
		File SourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, destinationFile);

	}

}
