package com.ps.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = ".card-title")
    private WebElement firstProductTitle;

    @FindBy(css = ".card-block h5")
    private WebElement firstProductPrice;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(firstProductTitle));
        firstProductTitle.click();
    }

    public WebElement getFirstProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(firstProductPrice));

        return firstProductPrice;
    }
}
