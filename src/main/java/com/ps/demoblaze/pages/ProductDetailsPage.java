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
    private final WebDriverWait wait;

    @FindBy(id = "more-information")
    private WebElement detailsInfo;

    @FindBy(css = ".price-container")
    private WebElement price;

    @FindBy(css = "h2.name")
    private WebElement productName;

    @FindBy(css = ".btn.btn-success")
    private WebElement addToCartBtn;

    @FindBy(css = "#imgp img")
    private WebElement productImg;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement getDetailsInfo() {
        return detailsInfo;
    }

    public WebElement getPrice() {
        wait.until(ExpectedConditions.visibilityOf(price));
        return price;
    }

    public WebElement getAddToCartBtn() {
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        return addToCartBtn;
    }

    public WebElement getProductName() {
        wait.until(ExpectedConditions.visibilityOf(productName));
        return productName;
    }

    public WebElement getProductImg() {
        wait.until(ExpectedConditions.visibilityOf(productImg));
        return productImg;
    }
}
