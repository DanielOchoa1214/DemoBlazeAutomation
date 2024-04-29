package com.ps.demoblaze.pages;

import org.openqa.selenium.By;
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
    @FindBy(css = "a#cartur")
    private WebElement cartButton;

    public WebElement getCartButton() {
        return cartButton;
    }
    @FindBy(id = "signin2")
    private WebElement signUpBtn;

    public WebElement getSignUpBtn() {
        wait.until(ExpectedConditions.visibilityOf(signUpBtn));
        return signUpBtn;
    }
    @FindBy(id = "signInModalLabel")
    private WebElement signUpModal;

    public WebElement getSignUpModal() {
        wait.until(ExpectedConditions.visibilityOf(signUpModal));
        return signUpModal;
    }

    @FindBy(css = "a.nav-link[href='index.html']")
    private WebElement homeBtn;

    public WebElement getHomeBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(homeBtn));
        return homeBtn;
    }

    //Contact
    @FindBy(css = "a.nav-link[data-toggle='modal'][data-target='#exampleModal']")
    private WebElement contactBtn;

    public WebElement getContactBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
        return contactBtn;
    }

    @FindBy(id = "exampleModal")
    private WebElement modalContact;

    public WebElement getModalContact() {
        wait.until(ExpectedConditions.visibilityOf(modalContact));
        return modalContact;
    }

    public WebElement getCloseModalContact() {
        return getModalContact().findElement(By.cssSelector("#exampleModal .modal-footer button[data-dismiss='modal']"));
    }

    //About us
    @FindBy(css = "a.nav-link[data-toggle='modal'][data-target='#videoModal']")
    private WebElement aboutUsBtn;

    public WebElement getAboutUsBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutUsBtn));
        return aboutUsBtn;
    }

    @FindBy(id = "videoModal")
    private WebElement modalAboutUs;

    public WebElement getModalAboutUs() {
        wait.until(ExpectedConditions.visibilityOf(modalAboutUs));
        return modalAboutUs;
    }

    public WebElement getCloseModalAboutUs() {
        return getModalAboutUs().findElement(By.cssSelector("#videoModal .modal-footer button[data-dismiss='modal']"));
    }
    //Cart
    @FindBy(id = "cartur")
    private WebElement cartBtn;

    public WebElement getCartBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        return cartBtn;
    }
    //Login
    @FindBy(id = "login2")
    private WebElement loginBtn;

    public WebElement getLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        return loginBtn;
    }

    @FindBy(id = "logInModal")
    private WebElement modalLogin;

    public WebElement getModalLogin() {
        wait.until(ExpectedConditions.visibilityOf(modalLogin));
        return modalLogin;
    }

    public WebElement getCloseModalLogin() {
        return getModalLogin().findElement(By.cssSelector("#logInModal .modal-footer button[data-dismiss='modal']"));
    }

    //SignUp
    @FindBy(id = "signin2")
    private WebElement signinBtn;

    public WebElement getSigninBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signinBtn));
        return signinBtn;
    }

    @FindBy(id = "signInModal")
    private WebElement signInModal;

    public WebElement getSignInModal() {
        wait.until(ExpectedConditions.visibilityOf(signUpModal));
        return signInModal;
    }

    public WebElement getCloseModalSignIn() {
        return getSignInModal().findElement(By.cssSelector("#signInModal .modal-footer button[data-dismiss='modal']"));
    }







}
