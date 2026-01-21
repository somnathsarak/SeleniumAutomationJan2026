package com.automation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    static {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/" + timeStamp;
        new File(reportPath).mkdirs();
        
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath + "/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, " Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, " Test FAILED");
        extentTest.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
