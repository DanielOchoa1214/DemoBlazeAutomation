package com.ps.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(firstProductTitle));
        firstProductTitle.click();
    }

    public WebElement getFirstProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(firstProductPrice));
        return firstProductPrice;
    }

    public WebElement returnCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.withTimeout(Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        List<WebElement> categoryElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.list-group a.list-group-item")));

        List<WebElement> matchingCategories = new ArrayList<>();
        // Recorrer la lista de elementos
        for (WebElement elemento : categoryElements) {
            // Obtener el valor del atributo href
            String textoElemento = elemento.getText();

            // Verificar si el valor del atributo href es igual a "phone"
            if (category.equals(textoElemento)) {
                return elemento;
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("col-lg-9")));
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return null;
    }

    public WebElement findProduct(String nameProduct1) {
        // Esperar a que al menos un elemento esté presente en el DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("col-lg-9")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.card-block h4.card-title a.hrefch")));

        // Encontrar todos los elementos <a> dentro de los elementos <h4> con la clase "card-title"
        List<WebElement> products = driver.findElements(By.cssSelector("div.card-block h4.card-title a.hrefch"));

        // Esperar a que todos los elementos estén visibles
        wait.until(ExpectedConditions.visibilityOfAllElements(products));



        // Iterar sobre cada elemento <a> encontrado
        for (WebElement product : products) {
            String productName = product.getText();

            // Verificar si el nombre del producto coincide exactamente con el proporcionado
            if (productName.equals(nameProduct1)) {
                return product; // Devolver el elemento <a> encontrado
            }
        }

        // Si no se encuentra ningún producto que coincida, retornar null
        return null;
    }



    @FindBy(className = "carousel-control-next-icon")
    private WebElement carouselArrowRight;

    public WebElement getCarouselArrowRight() {
        wait.until(ExpectedConditions.visibilityOf(carouselArrowRight));
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("carousel-control-next-icon")));
        return  carouselArrowRight;
    }

    @FindBy(className = "carousel-control-prev-icon")
    private WebElement carouselArrowLeft;

    public WebElement getCarouselArrowLeft() {
        wait.until(ExpectedConditions.visibilityOf(carouselArrowLeft));
        return carouselArrowLeft;
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("carousel-control-prev-icon")));
    }

    @FindBy(css = "a.list-group-item")
    private List<WebElement> elements;

    public List<WebElement> getElements(){
        return elements;
    }

    @FindBy(css = "img.card-img-top.img-fluid")
    private WebElement monitor;

    public WebElement getMonitor() {
        wait.until(ExpectedConditions.visibilityOf(monitor));
        return monitor;
    }

    @FindBy(css = "#contcont a#itemc")
    private List<WebElement> filters;

    @FindBy(css = ".carousel-item")
    private WebElement firstCarouselImg;

    public List<WebElement> getFilters(){
        wait.until(ExpectedConditions.visibilityOfAllElements(filters));
        return filters;
    }

    public void filterProductsBy(int filter, String expectedTitle){
        getFilters().get(filter).click();
        wait.until(ExpectedConditions.textMatches(By.cssSelector(".card-title"), Pattern.compile(expectedTitle)));
    }

    public WebElement getFirstProductTitle() {
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(firstProductTitle));
        return firstProductTitle;
    }

    public WebElement getFirstCarouselImg(boolean isActive) {
        if (isActive) {
            wait.until(driver1 -> firstCarouselImg.getAttribute("class").contains("active"));
        } else {
            wait.until(driver1 -> !firstCarouselImg.getAttribute("class").contains("active"));
        }
        return firstCarouselImg;
    }
}
