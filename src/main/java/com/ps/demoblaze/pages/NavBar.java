package com.ps.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBar {
    private final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(id = "login2")
    private WebElement loginLink;

    @FindBy(id = "signin2")
    private WebElement signinLink;

    @FindBy(id = "nameofuser")
    private WebElement userName;

    @FindBy(css = "a.nav-link[href='index.html']")
    private WebElement homeLink;



    public NavBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void gotToCart(){
        cartLink.click();
    }

    public void gotToHome(){
        homeLink.click();
    }

    public WebElement getCartLink() {
        wait.until(ExpectedConditions.visibilityOf(cartLink));
        return cartLink;
    }

    public WebElement getLoginLink() {
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        return loginLink;
    }

    public WebElement getSigninLink() {
        wait.until(ExpectedConditions.visibilityOf(signinLink));
        return signinLink;
    }

    public WebElement getUserName() {
        wait.until(ExpectedConditions.visibilityOf(userName));
        return userName;
    }
}
