package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.pages.*;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductDetailsTest extends DemoBlazeTest {
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
    public void ECLAT_393_productRedirectsToCorrectPage(){
        mainPage.clickFirstProduct();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/prod.html?idp_=1");
    }

    @Test
    public void ECLAT_394_verifyADescriptionOfProductsExists() {
        mainPage.clickFirstProduct();
        Assert.assertNotNull(detailsPage.getDetailsInfo());
    }

    @Test
    public void ECLAT_447_verifyProductDetailsHasHighResolutionImages(){
        mainPage.clickFirstProduct();
        WebElement productImg = detailsPage.getProductImg();
        Assert.assertTrue(Integer.parseInt(productImg.getAttribute("width")) >= 400);
        Assert.assertTrue(Integer.parseInt(productImg.getAttribute("height")) >= 280);
    }

    @Test
    public void ECLAT_396_verifyPriceAppearsInDetailsPage() {
        mainPage.clickFirstProduct();
        Assert.assertNotNull(detailsPage.getPrice());
    }

    @Test
    public void ECLAT_397_verifyPriceMatchesCardAndDetails() {
        String firstProductPrice = mainPage.getFirstProductPrice().getText();
        mainPage.clickFirstProduct();

        Assert.assertTrue(detailsPage.getPrice().getText().contains(firstProductPrice));
    }

    @Test
    public void ECLAT_399_verifyAddToCartButtonExistsAndWorks() {
        mainPage.clickFirstProduct();
        String productName = detailsPage.getProductName().getText();
        WebElement addToCartBtn = detailsPage.getAddToCartBtn();

        Assert.assertNotNull(addToCartBtn);
        addToCartBtn.click();

        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
