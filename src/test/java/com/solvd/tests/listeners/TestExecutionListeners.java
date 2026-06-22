package com.solvd.tests.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " FAILED");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " STARTED");
    }
}