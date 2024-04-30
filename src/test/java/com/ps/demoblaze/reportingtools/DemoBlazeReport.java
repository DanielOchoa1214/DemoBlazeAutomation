package com.ps.demoblaze.reportingtools;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class DemoBlazeReport {
    private final ExtentSparkReporter htmlReporter;
    private final ExtentReports extent;
    private ExtentTest test;

    public DemoBlazeReport() {
        htmlReporter = new ExtentSparkReporter("reports/report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void setUpTest(Method m, String componentTest){
        test = extent.createTest(m.getName(), componentTest);
    }

    public void writeTestStatus(ITestResult result){
        switch (result.getStatus()){
            case ITestResult.SUCCESS -> test.pass("Test Passed");
            case ITestResult.FAILURE -> test.fail("Test failed");
        }
    }

    public void flushReport(){
        extent.flush();
    }
}
