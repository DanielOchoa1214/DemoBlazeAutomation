package com.ps.demoblaze.teststeps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends DemoBlazeTest{

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
    }

    @Test
    public void test1(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
