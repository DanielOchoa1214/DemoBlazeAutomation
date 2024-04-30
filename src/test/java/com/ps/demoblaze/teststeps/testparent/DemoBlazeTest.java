package com.ps.demoblaze.teststeps.testparent;

import com.ps.demoblaze.reportingtools.DemoBlazeReport;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class DemoBlazeTest {
    private static final DemoBlazeReport report = new DemoBlazeReport();

    @BeforeMethod
    public void beforeMethod(Method m){
        report.setUpTest(m, this.getClass().getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        report.writeTestStatus(result);
    }

    @AfterSuite
    public void afterClass() {
        report.flushReport();
    }
}
