package com.ps.demoblaze.e2e;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.*;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends DemoBlazeTest {

    private ChromeOptions options;
    private WebDriver driver;
    private MainPage mainPage;
    private ProductDetailsPage detailsPage;
    private NavBar navBar;
    private CartPage cartPage;
    private LoginForm loginForm;
    private CheckoutForm checkoutForm;

    @BeforeClass
    public void beforeClass(){
        options = new ChromeOptions();
        //options.addArguments("--headless=new");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        detailsPage = new ProductDetailsPage(driver);
        navBar = new NavBar(driver);
        cartPage = new CartPage(driver);
        loginForm = new LoginForm(driver);
        checkoutForm = new CheckoutForm(driver);
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void endToEndTest(String username, String password, String name, String country, String city, String card, String month, String year){
        //Login to the page
        navBar.getLoginLink().click();
        loginForm.login(username, password);
        String loggedInUser = navBar.getUserName().getText();
        Assert.assertTrue(loggedInUser.contains("pepito.perez@gmail.com"));

        // Filtering results
        WebElement monitorsFilter = mainPage.getFilters().get(2);
        Assert.assertEquals(monitorsFilter.getText(), "Monitors");
        monitorsFilter.click();

        // Going to first result
        String firstProductPrice = mainPage.getFirstProductPrice().getText().substring(1);
        mainPage.clickFirstProduct();
        Assert.assertTrue(detailsPage.getPrice().getText().contains(firstProductPrice));

        // Checking product details
        String productName = detailsPage.getProductName().getText();
        WebElement addToCartBtn = detailsPage.getAddToCartBtn();
        addToCartBtn.click();
        Alert alert = detailsPage.getAlert();
        Assert.assertEquals(alert.getText(), "Product added.");
        alert.accept();

        // Adding product to cart and going to it
        navBar.gotToCart();
        Assert.assertEquals(cartPage.getFirstElementTitle().getText(), productName);
        Assert.assertTrue(firstProductPrice.contains(cartPage.getFirstElementPrice().getText()));

        int totalCartPrice = Integer.parseInt(cartPage.getTotalPrice().getText());
        int firstPrice = Integer.parseInt(firstProductPrice);
        Assert.assertTrue(totalCartPrice >= firstPrice);

        // Filling checkout form
        cartPage.getPlaceOrderBtn().click();
        checkoutForm.fillPlaceOrder(name, country, city, card, month, year);
        Assert.assertEquals(checkoutForm.getPurchaseConfirmationMessage().getText(),"Thank you for your purchase!");

        String data = checkoutForm.getPurchaseDetails().getText().replaceAll("\\n", " ");
        Assert.assertTrue(data.contains(name) && data.contains(card));
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

}
