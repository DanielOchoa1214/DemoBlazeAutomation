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
        driver = new ChromeDriver();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='index.html']")));
        homeButton.click();
        actions.pause(Duration.ofSeconds(3)).perform();

        WebElement contactBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[data-toggle='modal'][data-target='#exampleModal']")));
        contactBtn.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        WebElement modal1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModal")));
        WebElement closeModal1 = modal1.findElement(By.cssSelector("#exampleModal .modal-footer button[data-dismiss='modal']"));
        closeModal1.click();
        actions.pause(Duration.ofSeconds(2)).perform();


        WebElement aboutUsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[data-toggle='modal'][data-target='#videoModal']")));
        aboutUsBtn.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        WebElement modal2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        WebElement closeModal2 = modal2.findElement(By.cssSelector("#videoModal .modal-footer button[data-dismiss='modal']"));
        closeModal2.click();
        actions.pause(Duration.ofSeconds(2)).perform();

        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        cartBtn.click();
        actions.pause(Duration.ofSeconds(2)).perform();

        WebElement logInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        logInBtn.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        WebElement modal3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        WebElement closeModal3 = modal3.findElement(By.cssSelector("#logInModal .modal-footer button[data-dismiss='modal']"));
        closeModal3.click();
        actions.pause(Duration.ofSeconds(2)).perform();

        WebElement SignUpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
        SignUpBtn.click();
        actions.pause(Duration.ofSeconds(2)).perform();
        WebElement modal4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        WebElement closeModal4 = modal4.findElement(By.cssSelector("#signInModal .modal-footer button[data-dismiss='modal']"));
        closeModal4.click();
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
