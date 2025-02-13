package org.Listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3; // Set the max retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("[RETRY] Retrying test: " + result.getName() + " (Attempt " + retryCount + ")");
            return true;  // Retry test
        }
        return false;  // Stop retrying
    }
}

