package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.NavBar;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavBarTest extends DemoBlazeTest {
    private WebDriver driver = null;
    NavBar navbar;
    WebDriverWait wait;
    private ChromeOptions options;

    @BeforeClass
    public void beforeClass(){
        options = new ChromeOptions();
        options.addArguments("--headless=new");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver(options);
        driver.get("https://demoblaze.com/");
        navbar = new NavBar(driver);
        driver.manage().window().maximize();
    }
    @Test()
    public void ECLAT_490_ClickingCartIcon(){
        navbar.getCartButton().click();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://demoblaze.com/cart.html";
        Assert.assertEquals(currentURL, expectedURL, "URL doesn't match");
    }

    @Test()
    public void ECLAT_565_NavBarFunctionality(){
        Actions actions = new Actions(driver);
        navbar.getHomeBtn().click();
        actions.pause(Duration.ofSeconds(3)).perform();

        navbar.getContactBtn().click();
        actions.pause(Duration.ofSeconds(2)).perform();
        navbar.getCloseModalContact().click();
        actions.pause(Duration.ofSeconds(2)).perform();

        navbar.getAboutUsBtn().click();
        actions.pause(Duration.ofSeconds(2)).perform();
        navbar.getCloseModalAboutUs().click();
        actions.pause(Duration.ofSeconds(2)).perform();

        navbar.getCartBtn().click();
        actions.pause(Duration.ofSeconds(2)).perform();

        navbar.getLoginBtn().click();
        actions.pause(Duration.ofSeconds(2)).perform();
        navbar.getCloseModalLogin().click();
        actions.pause(Duration.ofSeconds(2)).perform();

        navbar.getSigninBtn().click();
        actions.pause(Duration.ofSeconds(2)).perform();
        navbar.getCloseModalSignIn().click();
        actions.pause(Duration.ofSeconds(2)).perform();
    }
    @Test
    public void ECLAT_807_SignUpFRegistratForm(){
        navbar.getSignUpBtn().click();
        Assert.assertNotNull(navbar.getSignUpModal());
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
