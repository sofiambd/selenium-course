package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(className = "hello")
    WebElement assertLogin;

    @FindBy(className = "logo")
    WebElement homePageButton;

    @Step("Se obtiene el título para realizar el assert.")
    public String assertLoginPage(){

        String getTitle = assertLogin.getText();
        return getTitle;

    }

    @Step("Se pasa el título para realizar el assert.")
    public String titlePage(){

        String title = "Hello, Test Account!";
        return title;

    }

    @Step("Se regresa a la HomePage.")
    public void returnHomePage(){

        homePageButton.click();
    }

    @Step("Se regresa a la HomePage para luego ingresar a la página de Categories.")
    public CategoriesPage returnHomePageCategories(){

        homePageButton.click();
        return new CategoriesPage(driver);
    }
}

