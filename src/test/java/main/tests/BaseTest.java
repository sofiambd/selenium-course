package main.tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception{

        String driverPath = new File("drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() throws Exception {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}

