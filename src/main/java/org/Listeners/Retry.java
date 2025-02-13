package org.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.utils.CustomUtility;


public class Retry extends CustomUtility implements IRetryAnalyzer {

	int retryCount = 0;
	int maxRetryCount = 3;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {

			
			  System.out.println("Retrying test " + result.getName() + " with status " +
			  getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) +
			  " time(s).");
			 

				/*
				 * publishMessageInReports("Retrying test " + result.getName() + " with status "
				 * + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) +
				 * " time(s).");
				 */
			retryCount++;
			return true;
		}

		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
}
