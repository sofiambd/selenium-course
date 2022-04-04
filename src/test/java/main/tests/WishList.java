package main.tests;

import main.pages.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class WishList extends BaseTest{

    @Parameters({"emailAccount","passAccount","titleCategory","assertSubCategory","subCategoryTitle"})

    @Test
    public void test(String emailAccount, String passAccount,String titleCategory, String assertSubCategory, String subCategoryTitle){

        driver.get("http://magento-demo.lexiconn.com/");
        LoginPage loginPage = new LoginPage(driver);
        AccountLoginPage accountLoginPage = loginPage.enterLoginPage();
        MyAccountPage myAccountPage = accountLoginPage.enterMyAccount(emailAccount, passAccount);
        String getTitle = myAccountPage.assertLoginPage();
        String title = myAccountPage.titlePage();
        assertEquals(title,getTitle);
        CategoriesPage categoriesPage = myAccountPage.returnHomePageCategories();
        SubCategoriesPage subCategoriesPage = categoriesPage.enterCategories(titleCategory);
        String getTtl = subCategoriesPage.getTtl();
        String assertTtl = subCategoriesPage.assertTtl(assertSubCategory);
        assertEquals(assertTtl,getTtl);
        ProductsPage electronicsPage = subCategoriesPage.enterSubCatPage(subCategoryTitle);
        HomePage homePageReturn = electronicsPage.addElectronic();
        String upperName = electronicsPage.upperName();
        String assertNamePage = electronicsPage.assertNamePage();
        assertEquals(upperName,assertNamePage);
        homePageReturn.returnHomePage();

    }



}
