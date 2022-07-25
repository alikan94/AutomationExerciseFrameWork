package tests;

import org.testng.asserts.SoftAssert;
import pages.HomePage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ProductsPage;
import pages.SingleProductPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class BaseTest extends TestBaseRapor {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    SingleProductPage singleProductPage = new SingleProductPage();
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    public void navigateToHomePage() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        softAssert.assertTrue(homePage.logo.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        Driver.closeDriver();
    }

}
