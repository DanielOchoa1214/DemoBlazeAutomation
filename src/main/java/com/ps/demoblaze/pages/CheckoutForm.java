package com.ps.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CheckoutForm {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.card-block h4.card-title a.hrefch")
    private List<WebElement> products;

    public List<WebElement> getListProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        return products;
    }

    public WebElement firstProduct(){
        return getListProducts().get(0);
    }
    @FindBy(css = "a.btn.btn-success.btn-lg[onclick='addToCart(1)']")
    private WebElement addToCart1Btn;

    public WebElement getAddToCart1Btn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(addToCart1Btn));
        return addToCart1Btn;
    }
    @FindBy(css = "a.btn.btn-success.btn-lg[onclick='addToCart(2)']")
    private WebElement addToCart2Btn;

    public WebElement getAddToCart2Btn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(addToCart2Btn));
        return addToCart2Btn;
    }
    public Alert getAlert(){

        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    @FindBy(css = "a.nav-link[href='index.html']")
    private WebElement homeBtn;

    public WebElement getHomeBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
        return homeBtn;
    }
    public WebElement secondProduct(){
        return getListProducts().get(1);
    }

    @FindBy(css = "button.btn.btn-success[data-toggle=\"modal\"][data-target=\"#orderModal\"]")
    private WebElement placeOrderBtn;

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }
    @FindBy(id = "name")
    private WebElement nameInput;
    public WebElement getNameInput() {
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        return nameInput;
    }

    @FindBy(id = "country")
    private WebElement countryInput;
    public WebElement getCountryInput() {
        wait.until(ExpectedConditions.visibilityOf(countryInput));
        return countryInput;
    }

    @FindBy(id = "city")
    private WebElement cityInput;
    public WebElement getCityInput() {
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        return cityInput;
    }
    @FindBy(id = "card")
    private WebElement cardInput;
    public WebElement getCardInput() {
        wait.until(ExpectedConditions.visibilityOf(cardInput));
        return cardInput;
    }
    @FindBy(id = "month")
    private WebElement monthInput;
    public WebElement getMonthInput() {
        wait.until(ExpectedConditions.visibilityOf(monthInput));
        return monthInput;
    }
    @FindBy(id = "year")
    private WebElement yearInput;
    public WebElement getYearInput() {
        wait.until(ExpectedConditions.visibilityOf(yearInput));
        return yearInput;
    }
    @FindBy(css = "button.btn.btn-primary[onclick=\"purchaseOrder()\"]")
    private WebElement purchaseBtn;
    public WebElement getPurchaseBtn() {
        wait.until(ExpectedConditions.visibilityOf(purchaseBtn));
        return purchaseBtn;
    }

    @FindBy(css = ".sweet-alert h2")
    private WebElement purchaseConfirmationMessage;
    public WebElement getPurchaseConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(purchaseConfirmationMessage));
        return purchaseConfirmationMessage;
    }

    public void fillPlaceOrder(String name, String country, String city, String card, String month, String year){
        getNameInput().sendKeys(name);
        getCountryInput().sendKeys(country);
        getCityInput().sendKeys(city);
        getCardInput().sendKeys(card);
        getMonthInput().sendKeys(month);
        getYearInput().sendKeys(year);
        getPurchaseBtn().click();
    }

    @FindBy(css = "p.lead.text-muted")
    private WebElement purchaseDetails;
    public WebElement getPurchaseDetails() {
        wait.until(ExpectedConditions.visibilityOf(purchaseDetails));
        return purchaseDetails;
    }

    public List<String> getPurchaseDataList() {
        String dataText = getPurchaseDetails().getText();
        String[] lines = dataText.split("\\n");
        List<String> dataList = new ArrayList<>();

        // Agrega cada línea a la lista
        for (String line : lines) {
            dataList.add(line);
        }
        return dataList;
    }

    //    @FindBy(css = ".card-block h5")
    //private WebElement firstProduct;



}
