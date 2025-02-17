package com.ps.demoblaze.teststeps;

import com.ps.demoblaze.dataproviders.DemoBlazeDataProvider;
import com.ps.demoblaze.pages.MainPage;
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
import java.util.List;

public class MainPageTest extends DemoBlazeTest {
    private WebDriver driver = null;
    private MainPage mainPage;
    private WebDriverWait wait;
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
        mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().window().maximize();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_419_NavigToPhonesCategory(String category, String product){

        new Actions(driver)
                .click( mainPage.returnCategory(category))
                .pause(Duration.ofSeconds(3))
                .perform();

        String product1  = mainPage.findProduct(product).getText();
        Assert.assertEquals(product1,product);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_420_NavigToLaptopsCategory(String category, String product){

        new Actions(driver)
                .click( mainPage.returnCategory(category))
                .pause(Duration.ofSeconds(3))
                .perform();

        String product1  = mainPage.findProduct(product).getText();
        Assert.assertEquals(product1,product);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DemoBlazeDataProvider.class)
    public void ECLAT_421_NavigToMonitorsCategory(String category, String product){
        new Actions(driver)
                .click( mainPage.returnCategory(category))
                .pause(Duration.ofSeconds(3))
                .perform();

        //wait.withTimeout(Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        String product1  = mainPage.findProduct(product).getText();
        Assert.assertEquals(product1,product);
    }

    @Test
    public void ECLAT_552_NavElementsFunctionality(){
        // Testing carrousel functionality
        mainPage.getCarouselArrowRight().click();
        WebElement firstImg = mainPage.getFirstCarouselImg(false);
        Assert.assertFalse(firstImg.getAttribute("class").contains("active"));

        mainPage.getCarouselArrowLeft().click();
        firstImg = mainPage.getFirstCarouselImg(true);
        Assert.assertTrue(firstImg.getAttribute("class").contains("active"));

        // Testing filters
        List<WebElement> filters =  mainPage.getFilters();
        String[] products = new String[]{"Samsung galaxy s6", "Sony vaio i5", "Apple monitor 24"};

        for(int i = 0; i < filters.size(); i++){
            mainPage.filterProductsBy(i, products[i]);
            String firstProductTitle = mainPage.getFirstProductTitle().getText();
            Assert.assertEquals(firstProductTitle, products[i]);
        }
    }


    @Test
    public void ECLAT_711_FilteringProductType(){
        mainPage.returnCategory("Phones").click();

        new Actions(driver)
                .click(mainPage.returnCategory("Phones"))
                .pause(Duration.ofSeconds(2))
                .perform();

       String product = mainPage.findProduct("Iphone 6 32gb").getText();
       Assert.assertEquals(product,"Iphone 6 32gb");

        new Actions(driver)
                .click(mainPage.returnCategory("Laptops"))
                .pause(Duration.ofSeconds(2))
                .perform();


        String product2  = mainPage.findProduct("MacBook air").getText();
        Assert.assertEquals(product2,"MacBook air");

        new Actions(driver)
                .click(mainPage.returnCategory("Monitors"))
                .pause(Duration.ofSeconds(2))
                .perform();

        String product3  = mainPage.findProduct("Apple monitor 24").getText();
        Assert.assertEquals(product3,"Apple monitor 24");
    }


    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
