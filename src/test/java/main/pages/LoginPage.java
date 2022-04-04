package main.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "skip-account")
    WebElement accountButton;

    @FindBy(css = "[title='My Account']")
    WebElement myAccountButton;

    @Step("Se ingresa a la página de Login.")
    public AccountLoginPage enterLoginPage(){
        accountButton.click();
        myAccountButton.click();
        return new AccountLoginPage(driver);
    }
}