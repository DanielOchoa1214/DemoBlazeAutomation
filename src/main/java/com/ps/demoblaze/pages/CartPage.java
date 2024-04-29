package com.ps.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;

    @FindBy(css = ".success:nth-child(1) td:nth-child(1)")
    private WebElement firstElementImage;

    @FindBy(css = ".success:nth-child(1) td:nth-child(2)")
    private WebElement firstElementTitle;

    @FindBy(css = ".success:nth-child(1) td:nth-child(3)")
    private WebElement firstElementPrice;

    @FindBy(css = ".success:nth-child(1) a[href='#']")
    private WebElement firstElementDelete;

    @FindBy(id = "totalp")
    private WebElement totalPrice;
    @FindBy(css = ".btn-success")
    private WebElement placeOrderBtn;

    @FindBy(id = "orderModalLabel")
    private WebElement placeOrderTitle;

    @FindBy(css = "#orderModal .btn-secondary")
    private WebElement closeBtn;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstElementTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstElementTitle));

        return firstElementTitle;
    }
    @FindBy(css = "a#cartur")
    private WebElement cartButton;

    public WebElement getCartButton() {
            return cartButton;
    }

    public WebElement getFirstElementPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstElementPrice));

        return firstElementPrice;
    }

    public WebElement getFirstElementImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstElementImage));

        return firstElementImage;
    }

    public WebElement getFirstElementDelete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstElementDelete));

        return firstElementDelete;
    }

    public WebElement getTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(totalPrice));

        return totalPrice;
    }
    public WebElement getPlaceOrderBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));

        return placeOrderBtn;
    }
    public WebElement getPlaceOrderTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(placeOrderTitle));

        return placeOrderTitle;
    }

    public WebElement getCloseBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(closeBtn));

        return closeBtn;
    }
}
