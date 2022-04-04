package main.tests;

import main.pages.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Products extends BaseTest{


    @Parameters({"titleCategory","assertSubCategory","subCategoryTitle","titleElement","titleProduct","assertProductTitle"})

    @Test
    public void test(String titleCategory,String assertSubCategory,String subCategoryTitle,String titleElement, String titleProduct, String assertProductTitle){

        driver.get("http://magento-demo.lexiconn.com/");
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        SubCategoriesPage subCategoriesPage = categoriesPage.enterCategories(titleCategory);
        String getTtl = subCategoriesPage.getTtl();
        String assertTtl = subCategoriesPage.assertTtl(assertSubCategory);
        assertEquals(assertTtl,getTtl);
        ProductsPage productsPage = subCategoriesPage.enterSubCatPage(subCategoryTitle);
        productsPage.buyProduct(titleElement);
        String productName = productsPage.productName();
        String upperCaseTtl = productsPage.upperCaseTitle(titleProduct);
        assertEquals(upperCaseTtl,productName);
        ShoppingCart shoppingCart = productsPage.buyProduct();
        String productNameCart = shoppingCart.assertProductName();
        assertEquals(assertProductTitle,productNameCart);
        HomePage homePage = shoppingCart.removeItem();
        homePage.returnHomePage();


    }

}
