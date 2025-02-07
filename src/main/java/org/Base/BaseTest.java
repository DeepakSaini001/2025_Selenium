package org.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.Constants.Constants;
import org.Constants.DriverType;
import org.DriverFactory.DriverManagerFactory;
import org.DriverFactory.DriverManager_original;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
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
import org.utils.LogUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BaseTest {

	protected ExtentReports report;
	protected ExtentTest test;
	protected static Logger log = LogUtils.getLogger();

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/*
	 * ThreadLocal is used to create variables that are local to the thread. Each
	 * thread accessing the ThreadLocal variable gets its own independent copy,
	 * meaning that one thread cannot interfere with another's data. This is crucial
	 * in test automation when running tests in parallel, as each test (running in
	 * its own thread) can have its own instance of WebDriver without conflicts.
	 */

	public void setDriver(WebDriver driver) {
		this.driver.set(driver); // Set the WebDriver for the current thread

	}

	public WebDriver getDriver() {
		return this.driver.get();// Retrieve the WebDriver for the current thread

	}

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		report = ExtentReporterNG.getInstance();
		log.info("Initialize Extent Reports successfully");
	}

	@BeforeMethod
	public void startDriver(@Optional String browser, ITestResult result) {

		browser = System.getProperty("browser", browser);

		if (browser == null || browser.isEmpty()) {
			browser = "CHROME";
		}
		try {
			
			WebDriver initializedDriver = DriverManagerFactory.getManager(DriverType.valueOf(browser.toUpperCase())).InitilizeDriver();
	        setDriver(initializedDriver);
		
	        
	        if (getDriver() == null) {
	            throw new RuntimeException("WebDriver is null after initialization!");
	        }
			System.out.println("Current thread"+ " : " + Thread.currentThread().getId() + ", " + "Driver --> startDriver : "
					+ getDriver());
			test = report.createTest(result.getMethod().getMethodName());
			System.out.println("TestCase Started: " + test.getModel().getName());
			log.info("Driver initialized for test: " + result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Driver initialization failed! Browser: " + browser);
			
		}
	}

	@AfterMethod
	public void quitDriver(@Optional String browser, ITestResult result) throws IOException {
		
		 WebDriver currentDriver = getDriver();

		 
		 if (currentDriver != null) {
		System.out.println("Current thread "+ " : " + Thread.currentThread().getId()+ " : " + ", Driver --> QuitDriver: " + getDriver()
				+ ", Date & Time : " + Constants.Timestamp);
		
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed at " + Constants.Timestamp);
		} else if (result.getStatus() == ITestResult.FAILURE) {

			File destinationFile = new File("ScreenShot" + File.separator + browser + File.separator
					+ result.getTestClass().getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName()
					+ "_" + Constants.Timestamp + ".png");
			takeScreenshot(destinationFile);
			test.log(Status.FAIL, "Test Failed at " + Constants.Timestamp + " : " + result.getThrowable())
					.addScreenCaptureFromPath(destinationFile.getAbsolutePath());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped at " + Constants.Timestamp + " : " + result.getThrowable());
		}
		
	     try {
	            currentDriver.quit();
	            log.info("Driver quit successfully for TestCase Name: " + result.getMethod().getMethodName());
	        } catch (Exception e) {
	            log.error("Error while quitting the driver", e);
	        } finally {
	            setDriver(null); // Ensure the ThreadLocal variable is cleared
	        }
	    } else {
	        log.warn("Driver is already null, skipping quit.");
	    }
	 
	    report.flush();
	}


	private void takeScreenshot(File destinationFile) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot) getDriver());
		File SourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SourceFile, destinationFile);

	}

	@AfterSuite
	public void openHtmlReport() {
		try {
			File htmlFile = new File(System.getProperty("user.dir") + File.separator + "Reports" + File.separator
					+ Constants.ReportName);
			if (htmlFile.exists()) {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} else {
				System.out.println("Report file not found: " + htmlFile.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
