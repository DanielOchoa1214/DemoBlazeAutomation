package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.*;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends DemoBlazeTest {

    private ChromeOptions options;
    private WebDriver driver;
    private MainPage mainPage;
    private ProductDetailsPage detailsPage;
    private NavBar navBar;
    private CartPage cartPage;

    private SignUpForm signUpForm;
    @BeforeClass
    public void beforeClass(){
        options = new ChromeOptions();
        options.addArguments("--headless=new");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        detailsPage = new ProductDetailsPage(driver);
        navBar = new NavBar(driver);
        cartPage = new CartPage(driver);
        signUpForm = new SignUpForm(driver);
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test
    public void ECLAT_798_verifyVisibilySignUpLink(){
        Assert.assertTrue(navBar.getSigninLink().isDisplayed());
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_802_SignUpValidation(String username, String password) {
        navBar.getSigninLink().click();
        signUpForm.signin(username, password);

        Alert errorAlert = signUpForm.getErrorAlert();
        String errorMessage = errorAlert.getText();

        Assert.assertEquals(errorMessage, "This user already exist.");
        errorAlert.accept();
    }
    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_805_correctSignUp(String username, String password) {
        navBar.getSigninLink().click();
        signUpForm.signin(username, password);

        Alert errorAlert = signUpForm.getErrorAlert();
        String errorMessage = errorAlert.getText();

        Assert.assertEquals(errorMessage, "Sign up successful.");
        errorAlert.accept();
    }

}
