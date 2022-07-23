package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TestCase03 extends BaseTest {

    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter incorrect email address and password
            7. Click 'login' button
            8. Verify error 'Your email or password is incorrect!' is visible
     */

    //SoftAssert softAssert = new SoftAssert();

    @Test
    public void LoginUserWithIncorrectEmailAndPasswordTest() {
        extentTest=extentReports.createTest("TC003_LoginUserWithIncorrectEmailAndPassword",
                "User can login with correct email and password");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        /* first three steps are done at the parent class*/


        extentTest.info("Navigated to AE website homepage.");

        //4. Click on 'Signup / Login' button
        ReusableMethods.waitFor(2);
        homePage.signUpHeader.click();
        extentTest.info("Clicked to login button on the header.");

        //5. Verify 'Login to your account' is visible
        softAssert.assertTrue(homePage.loginToYourAccountTitle.isDisplayed());
        extentTest.pass("'Login To Your Account' title is displayed");

        //6. Enter incorrect email address and password
        homePage.loginUserNameTextBox.sendKeys(ConfigReader.getProperty("aeWrongMail"));
        homePage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("aeWrongPassword"));
        extentTest.info("Entered incorrect email address and password.");

        //7. Click 'login' button
        homePage.loginButton.click();
        extentTest.info("Clicked to login button on the login page.");

        //8. Verify error 'Your email or password is incorrect!' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.loginErrorText.isDisplayed());
        extentTest.pass("'Your email or password is incorrect!' is visible");
        //softAssert.assertAll();

    }
}
