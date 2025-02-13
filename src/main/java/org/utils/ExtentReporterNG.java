package org.utils;

import org.Constants.Constants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	private static ExtentReports report;

	public static ExtentReports createInstance(String fileName) {
		// file name-- is coming from the below getinstance method.
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Test Report");

		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host Name", "TestMachine");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Deepak");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", System.getProperty("os.name"));

		return report;
	}

	public static ExtentReports getInstance() {
		if (report == null) {
			System.out.println("Creating new ExtentReports instance...");
			report = createInstance(System.getProperty("user.dir") + "//Reports//" + Constants.ReportName);
		} else {
			System.out.println("Reusing existing ExtentReports instance...");
		}
		return report;
	}

}
