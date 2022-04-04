package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class SubCategoriesPage extends BasePage{

    public SubCategoriesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "category-title")
    WebElement assertTitlePage;

    @FindBy(css = "a[href*='color=20']")
    WebElement shopBySelection;

    @FindBy(css = "[title='View Details']")
    WebElement viewDetails;



    @Step("Se extrae el título de la categoría de la página.")
    public String getTtl(){

        String titleCategoryPage = assertTitlePage.getText();
        return titleCategoryPage;
    }
    @Step("Se ingresa títlo con el que se va a realizar el assert.")
    public String assertTtl(String assertSubCategory){

        String upperTtl = assertSubCategory.toUpperCase();
        return upperTtl;
    }

    @Step("Método que ingresa a la Subcategoría de Pants & Denim.")
    public ProductsPage enterSubCategoryPage(String subCategoryTitle){

        driver.findElement(By.cssSelector("[alt='"+subCategoryTitle+"']")).click();
        shopBySelection.click();
        viewDetails.click();
        return new ProductsPage(driver);

    }

    @Step("Método que ingresa a la Subcategoría correspondiente.")
    public ProductsPage enterSubCatPage(String subCategoryTitle){

        driver.findElement(By.cssSelector("[alt='"+subCategoryTitle+"']")).click();
        return new ProductsPage(driver);

    }



}
