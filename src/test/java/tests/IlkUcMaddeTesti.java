package tests;

import pages.AePage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class IlkUcMaddeTesti extends TestBaseRapor {

    AePage aePage = new AePage();
    Faker faker = new Faker();

    @BeforeClass
    public void homePageGorunurlukTesti() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        Assert.assertTrue(aePage.logo.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
