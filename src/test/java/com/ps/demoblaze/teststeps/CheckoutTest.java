package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.CartPage;
import com.ps.demoblaze.pages.CheckoutForm;
import com.ps.demoblaze.pages.MainPage;
import com.ps.demoblaze.teststeps.testparent.DemoBlazeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends DemoBlazeTest {

    private WebDriver driver = null;
    CheckoutForm checkoutForm;
    CartPage cartPage;
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
        checkoutForm = new CheckoutForm(driver);
        cartPage = new CartPage(driver);
        //driver.manage().window().maximize();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_904_CompletionCheckoutProcess(String name, String country, String city, String card, String month, String year) {
      checkoutForm.firstProduct().click();
      checkoutForm.getAddToCart1Btn().click();
      Alert alert = checkoutForm.getAlert();
      alert.accept();
      checkoutForm.getHomeBtn().click();
      checkoutForm.secondProduct().click();
      checkoutForm.getAddToCart2Btn().click();
      Alert alert2 = checkoutForm.getAlert();
      alert2.accept();
      cartPage.getCartButton().click();
      checkoutForm.getPlaceOrderBtn().click();
      checkoutForm.fillPlaceOrder( name,  country,  city,  card,  month,  year);
      Assert.assertEquals(checkoutForm.getPurchaseConfirmationMessage().getText(),"Thank you for your purchase!");


    }

    @AfterMethod
    public void afterMethod() {
    //    driver.close();
    }
}
