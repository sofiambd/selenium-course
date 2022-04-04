package main.tests;

import main.dataProviders.LanguagesData;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Languages extends BaseTest{


    @Test(dataProvider = "languages", dataProviderClass = LanguagesData.class)
    public void test(String languageTitle, String assertLanguage){

        driver.get("http://magento-demo.lexiconn.com/");
        driver.findElement(By.id("select-language")).click();
        driver.findElement(By.cssSelector("option[value*='"+languageTitle+"']")).click();
        String languageText = driver.findElement(By.cssSelector("[title='"+assertLanguage+"']")).getText();
        String upper = assertLanguage.toUpperCase();
        Assert.assertEquals(upper,languageText);

    }

}
