package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "logo")
    WebElement homePageButton;

    @Step("Se regresa a la HomePage.")
    public void returnHomePage(){
        homePageButton.click();
    }




}
