package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.pages.CartPage;
import com.ps.demoblaze.pages.MainPage;
import com.ps.demoblaze.pages.NavBar;
import com.ps.demoblaze.pages.ProductDetailsPage;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class CartPageTest extends DemoBlazeTest {
    private ChromeOptions options;
    private WebDriver driver;
    private MainPage mainPage;
    private ProductDetailsPage detailsPage;
    private NavBar navBar;
    private CartPage cartPage;

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
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test
    public void ECLAT_491_productInCart(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();
        WebElement addToCartBtn = detailsPage.getAddToCartBtn();

        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);
    }

    @Test
    public void ECLAT_492_productOverviewInCart(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();
        String productPrice = detailsPage.getPrice().getText();

        String[] parts = productPrice.split("\\$");
        String price = parts[1].replaceAll("[^\\d]", "");

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();

        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();

        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);
        Assert.assertEquals(cartPage.getFirstElementPrice().getText(), price);
    }

    @Test
    public void ECLAT_494_eliminateProductFromCart(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);

        WebElement deleteBtn = cartPage.getFirstElementDelete();
        deleteBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(deleteBtn));

    }

    @Test
    public void ECLAT_495_verifyCartPrice(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);

        Assert.assertEquals(cartPage.getTotalPrice().getText(), cartPage.getFirstElementPrice().getText());

        WebElement deleteBtn = cartPage.getFirstElementDelete();
        deleteBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(cartPage.getTotalPrice()));

    }

    @Test
    public void ECLAT_496_productVisibility(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);

        driver.navigate().refresh();

        Assert.assertTrue(cartPage.getFirstElementTitle().isDisplayed());

        navBar.gotToHome();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/index.html");

        navBar.gotToCart();

        Assert.assertTrue(cartPage.getFirstElementTitle().isDisplayed());
    }

    @Test
    public void ECLAT_898_verifyCartPrice(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);

        Assert.assertEquals(cartPage.getTotalPrice().getText(), cartPage.getFirstElementPrice().getText());

        WebElement deleteBtn = cartPage.getFirstElementDelete();
        deleteBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(cartPage.getTotalPrice()));

    }

    @Test
    public void ECLAT_899_verifyPlaceOrderBtn(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);

        WebElement placeOrderBtn = cartPage.getPlaceOrderBtn();
        placeOrderBtn.click();

        Assert.assertTrue(cartPage.getPlaceOrderTitle().isDisplayed());
    }
    @Test
    public void ECLAT_900_verifyCloseBtn(){
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();

        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        detailsPage.getAlert().accept();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);

        WebElement placeOrderBtn = cartPage.getPlaceOrderBtn();
        placeOrderBtn.click();

        Assert.assertTrue(cartPage.getPlaceOrderTitle().isDisplayed());

        WebElement closeBtn = cartPage.getCloseBtn();
        WebElement placeOrderTitle = cartPage.getPlaceOrderTitle();
        closeBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(placeOrderTitle));
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

}
