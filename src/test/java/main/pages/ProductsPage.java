package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "links_20")
    WebElement checkboxItem;

    @FindBy(css = "[title='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(css = ".link-wishlist")
    WebElement productButton;

    @FindBy(className = "title-buttons")
    WebElement titleWishList;

    @FindBy(id = "attribute92")
    WebElement colorOptionButton;


    @FindBy(id = "attribute180")
    WebElement sizeOptionButton;


    @Step("Se realiza assert del producto de Books&Music y luego se selecciona el checkbox correspondiente para agregarlo al Shopping Cart.")
    public void buyProduct(String titleElement){

        driver.findElement(By.cssSelector("[title='"+titleElement+"']")).click();

    }
    @Step("Se realiza assert del producto de Books&Music y luego se selecciona el checkbox correspondiente para agregarlo al Shopping Cart.")
    public String productName(){

        String productName = driver.findElement(By.className("h1")).getText();
        return productName;

    }
    @Step("Se realiza assert del producto de Books&Music y luego se selecciona el checkbox correspondiente para agregarlo al Shopping Cart.")
    public String upperCaseTitle(String titleProduct){

        String upper = titleProduct.toUpperCase();
        return upper;

    }
    @Step("Se realiza assert del producto de Books&Music y luego se selecciona el checkbox correspondiente para agregarlo al Shopping Cart.")
    public ShoppingCart buyProduct(){

        checkboxItem.click();
        addToCartButton.click();

        return new ShoppingCart(driver);

    }


    @Step("Se agrega a la WishList un producto seleccionado en Electronics.")
    public HomePage addElectronic(){

        addToCartButton.click();
        productButton.click();
        return new HomePage(driver);
    }


    @Step("Se ingresa el título para el assert.")
    public String upperName(){
        String titlePage = "My Wishlist";
        String upperTitlePage = titlePage.toUpperCase();
        return upperTitlePage;
    }


    @Step("Se obtiene el titulo de la Wish List Page.")
    public String assertNamePage(){
        String titleWishListPage = titleWishList.getText();
        return titleWishListPage;
    }


    @Step("Se selecciona características en el dropdown del producto seleccionado en Pants&Denim.")
    public ShoppingCart addToCartDenimProduct(){

        colorOptionButton.click();
        Select dropdownColor = new Select(driver.findElement(By.id("attribute92")));
        dropdownColor.selectByVisibleText("Black");
        sizeOptionButton.click();
        Select dropdownSize = new Select(driver.findElement(By.id("attribute180")));
        dropdownSize.selectByVisibleText("31");
        addToCartButton.click();
        return new ShoppingCart(driver);

    }

}
