package com.ps.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginForm {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "loginusername")
    private WebElement userNameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(css = "#logInModal .btn-primary")
    private WebElement loginBtn;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        getUserNameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getLoginBtn().click();
    }

    public WebElement getUserNameInput() {
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        return userNameInput;
    }

    public WebElement getPasswordInput() {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        return passwordInput;
    }

    public WebElement getLoginBtn() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn;
    }
}
