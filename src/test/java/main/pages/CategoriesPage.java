package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends BasePage{

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Se ingresa al Categoría que se necesite desde la página principal.")
    public SubCategoriesPage enterCategories(String titleCategory){

        driver.findElement(By.className(titleCategory)).click();
        return new SubCategoriesPage(driver);
    }
}
