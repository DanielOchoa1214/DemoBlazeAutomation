package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.LoginForm;
import com.ps.demoblaze.pages.NavBar;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends DemoBlazeTest {
    private ChromeOptions options;
    private WebDriver driver;
    private NavBar navBar;
    private LoginForm loginForm;

    @BeforeClass
    public void beforeClass(){
        options = new ChromeOptions();
        options.addArguments("--headless=new");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver(options);
        loginForm = new LoginForm(driver);
        navBar = new NavBar(driver);
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_965_validLoginTest(String username, String password) {
        navBar.getLoginLink().click();
        loginForm.login(username, password);

        String loggedInUser = navBar.getUserName().getText();

        Assert.assertTrue(loggedInUser.contains("pepito.perez@gmail.com"));
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_966_invalidLoginTest(String username, String password) {
        navBar.getLoginLink().click();
        loginForm.login(username, password);

        Alert errorAlert = loginForm.getErrorAlert();
        String errorMessage = errorAlert.getText();

        Assert.assertEquals(errorMessage, "Wrong password.");
        errorAlert.accept();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
