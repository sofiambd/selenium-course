package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class ShoppingCart extends BasePage{

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "dd")
    WebElement productTitle;

    @FindBy(id = "empty_cart_button")
    WebElement removeItem;

    @Step("Se obtiene el título del producto para realizar el assert correspondiente.")
    public String assertProductName(){

        String productNameCart = productTitle.getText();
        return productNameCart;

    }

    @Step("Se elimina producto una vez agregado al Shopping Cart.")
    public HomePage removeItem(){

        removeItem.click();
        return new HomePage(driver);

    }
}
