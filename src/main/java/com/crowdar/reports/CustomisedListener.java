package com.crowdar.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;



public class CustomisedListener implements ITestListener {
    private static final Logger LOGGER = LoggerFactory.getLogger("CUSTOM_LOGS");

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("PASSED TEST CASES");
        context.getPassedTests()
                .getAllResults()
                .forEach(result -> {
                    LOGGER.info(result.getName());
                });
        LOGGER.info("FAILED TEST CASES");
        context.getFailedTests()
                .getAllResults()
                .forEach(result -> {
                    LOGGER.info(result.getName());
                });
        LOGGER.info("Test completed on: " + context.getEndDate()
                .toString());
    }

    @Override
    public void onStart(ITestContext arg0) {
        LOGGER.info("Started testing on: " + arg0.getStartDate()
                .toString());
    }
}