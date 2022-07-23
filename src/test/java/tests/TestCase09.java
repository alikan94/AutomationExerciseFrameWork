package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.SingleProductPage;
import utilities.ConfigReader;

public class TestCase09 extends BaseTest{

    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. Enter product name in search input and click search button
            7. Verify 'SEARCHED PRODUCTS' is visible
            8. Verify all the products related to search are visible
     */

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();

    @Test
    public void VerifyAllProductsAndProductDetailPageTest() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        // first three steps are done at the parent class
        extentTest = extentReports.createTest("TC08_VerifyAllProductsAndProductDetailPageTest",
                "Verify All Products and product detail page");

        extentTest.info("Navigated to AE website homepage.");

        //4. Click on 'Products' button
        homePage.click(homePage.productsHeaderButton);
        extentTest.info("Clicked on 'Products' button.");

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        productsPage.waitVisibility(productsPage.allProductsTitle);
        softAssert.assertTrue(productsPage.allProductsTitle.isDisplayed());
        extentTest.pass("User is navigated to ALL PRODUCTS page successfully.");

        //6. Enter product name in search input and click search button
        productsPage.writeText(productsPage.searchTextBox, ConfigReader.getProperty("aeSearchedProductName"));
        productsPage.click(productsPage.searchButton);
        extentTest.info("Entered product name in search input and clicked search button.");

        //7. Verify 'SEARCHED PRODUCTS' is visible

        //8. Verify all the products related to search are visible
    }
}
