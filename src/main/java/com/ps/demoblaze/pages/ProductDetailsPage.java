package com.ps.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    private final WebDriver driver;

    @FindBy(id = "more-information")
    private WebElement detailsInfo;

    @FindBy(css = ".price-container")
    private WebElement price;

    @FindBy(css = "h2.name")
    private WebElement productName;

    @FindBy(css = ".btn.btn-success")
    private WebElement addToCartBtn;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDetailsInfo() {
        return detailsInfo;
    }

    public WebElement getPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(price));

        return price;
    }

    public WebElement getAddToCartBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));

        return addToCartBtn;
    }

    public WebElement getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productName));

        return productName;
    }
}
