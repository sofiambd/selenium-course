package main.tests;

import main.pages.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class ShopBy extends BaseTest{

    @Parameters({"titleCategory","assertSubCategory","subCategoryTitle"})

    @Test
    public void test(String titleCategory,String assertSubCategory,String subCategoryTitle){

        driver.get("http://magento-demo.lexiconn.com/");
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        SubCategoriesPage subCategoriesPage = categoriesPage.enterCategories(titleCategory);
        String getTtl = subCategoriesPage.getTtl();
        String assertTtl = subCategoriesPage.assertTtl(assertSubCategory);
        assertEquals(assertTtl,getTtl);
        ProductsPage pantsDenimPage = subCategoriesPage.enterSubCategoryPage(subCategoryTitle);
        ShoppingCart shoppingCart = pantsDenimPage.addToCartDenimProduct();
        HomePage homePage = shoppingCart.removeItem();
        homePage.returnHomePage();

    }


}
