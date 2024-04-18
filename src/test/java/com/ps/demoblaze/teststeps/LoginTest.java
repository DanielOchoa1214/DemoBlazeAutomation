package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.LoginForm;
import com.ps.demoblaze.pages.NavBar;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends DemoBlazeTest {
    private WebDriver driver;
    private NavBar navBar;
    private LoginForm loginForm;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        loginForm = new LoginForm(driver);
        navBar = new NavBar(driver);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void validLoginTest(String username, String password) throws InterruptedException {
        navBar.getLoginLink().click();
        loginForm.login(username, password);

        String loggedInUser = navBar.getUserName().getText();

        Assert.assertTrue(loggedInUser.contains("pepito.perez@gmail.com"));
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
