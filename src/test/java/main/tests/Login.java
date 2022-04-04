package main.tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import main.pages.AccountLoginPage;
import main.pages.HomePage;
import main.pages.LoginPage;
import main.pages.MyAccountPage;

import static org.testng.Assert.assertEquals;


public class Login extends BaseTest{

    @Parameters({"emailAccount","passAccount"})

    @Test
    public void test(String emailAccount, String passAccount){

        driver.get("http://magento-demo.lexiconn.com/");
        LoginPage loginPage = new LoginPage(driver);
        AccountLoginPage accountLoginPage = loginPage.enterLoginPage();
        MyAccountPage myAccountPage = accountLoginPage.enterMyAccount(emailAccount,passAccount);
        String getTitle = myAccountPage.assertLoginPage();
        String title = myAccountPage.titlePage();
        assertEquals(title,getTitle);
        myAccountPage.returnHomePage();


    }


}
