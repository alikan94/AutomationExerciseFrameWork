package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.SingleProductPage;
import utilities.ReusableMethods;

public class TestCase08 extends BaseTest{

    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. The products list is visible
            7. Click on 'View Product' of first product
            8. User is landed to product detail page
            9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    SingleProductPage singleProductPage = new SingleProductPage();

    @Test
    public void VerifyAllProductsAndProductDetailPageTest() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully

        // first three steps are done at the parent class
        extentTest=extentReports.createTest("TC08_VerifyAllProductsAndProductDetailPageTest",
                "Verify All Products and product detail page");

        extentTest.info("Navigated to AE website homepage.");

        //4. Click on 'Products' button
        homePage.click(homePage.productsHeaderButton);
        extentTest.info("Clicked on 'Products' button.");

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        productsPage.waitVisibility(productsPage.allProductsTitle);
        softAssert.assertTrue(productsPage.allProductsTitle.isDisplayed());
        extentTest.pass("User is navigated to ALL PRODUCTS page successfully.");

        //6. The products list is visible
        softAssert.assertTrue(productsPage.allProductsAreVisible());
        extentTest.pass("The products list is visible.");

        //7. Click on 'View Product' of first product
        ReusableMethods.click(productsPage.firstProduct);
        extentTest.info("Clicked on 'View Product' of first product.");

        //8. User is landed to product detail page
        softAssert.assertTrue(singleProductPage.addToCartButton.isDisplayed());
        extentTest.info("User is landed to product detail page.");

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        softAssert.assertTrue(singleProductPage.firstProductName.isDisplayed());
        extentTest.pass("The product name is visible.");
        softAssert.assertTrue(singleProductPage.firstProductCategory.isDisplayed());
        extentTest.pass("The category is visible.");
        softAssert.assertTrue(singleProductPage.firstProductPrice.isDisplayed());
        extentTest.pass("The price is visible.");
        softAssert.assertTrue(singleProductPage.firstProductAvailability.isDisplayed());
        extentTest.pass("The availability is visible.");
        softAssert.assertTrue(singleProductPage.firstProductCondition.isDisplayed());
        extentTest.pass("The condition is visible.");
        softAssert.assertTrue(singleProductPage.firstProductBrand.isDisplayed());
        extentTest.pass("The brand is visible.");
    }
}
