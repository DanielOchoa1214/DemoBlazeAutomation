package com.ps.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpForm {
    private final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(id = "sign-username")
    private WebElement userNameLabel;

    @FindBy(id = "sign-password")
    private WebElement userPasswordLabel;

    @FindBy(css = "#signInModal .btn-primary")
    private WebElement signUpButton;


    public SignUpForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void signin(String username, String password){
        getUserNameLabel().sendKeys(username);
        getUserPasswordLabel().sendKeys(password);
        getSignUpButton().click();
    }

    public WebElement getUserNameLabel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userNameLabel));

        return userNameLabel;
    }

    public WebElement getUserPasswordLabel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userPasswordLabel));

        return userPasswordLabel;
    }

    public WebElement getSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signUpButton));

        return signUpButton;
    }

    public Alert getErrorAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

}
