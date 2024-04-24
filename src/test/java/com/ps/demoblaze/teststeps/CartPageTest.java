package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CartPageTest extends DemoBlazeTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
    }

    @Test
    public void test3(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
