package tests;

import Pages.AePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class IlkUcMaddeTesti {

    AePage aePage = new AePage();

    @BeforeClass
    public void homePageGorunurlukTesti() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        Assert.assertTrue(aePage.logo.isDisplayed());
    }

    //@AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }

}
