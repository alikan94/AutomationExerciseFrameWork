package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TestCase02 extends IlkUcMaddeTesti {
    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible
            9. Click 'Delete Account' button
            10. Verify that 'ACCOUNT DELETED!' is visible
     */

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginAndDeleteAccountTest() {
/*
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
 */
        // first three steps are done at the parent class

        extentTest=extentReports.createTest("TC002_LoginUserWithCorrectEmailAndPassword",
                "User can login with correct email and password");


        extentTest.info("Navigated to AE website homepage.");
        //4. Click on 'Signup / Login' button
        ReusableMethods.waitFor(2);
        aePage.signUpHeader.click();
        extentTest.info("Clicked to login button on the header.");
        //5. Verify 'Login to your account' is visible
        softAssert.assertTrue(aePage.loginToYourAccountTitle.isDisplayed());
        extentTest.pass("'Login To Your Account' title is displayed");
        //6. Enter correct email address and password
        aePage.loginUserNameTextBox.sendKeys(ConfigReader.getProperty("aeValidMail"));
        aePage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("aeValidPassword"));
        extentTest.info("Entered correct email address and password.");
        //7. Click 'login' button
        aePage.loginButton.click();
        extentTest.info("Clicked to login button on the login page.");
        //8. Verify that 'Logged in as username' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(aePage.loggedInAsUserNameHeader.isDisplayed());
        extentTest.pass("'Logged in as username' is visible.");

        //9. Click 'Delete Account' button
        aePage.deleteAccountHeader.click();
        extentTest.info("Clicked 'Delete Account' button.");

        //10. Verify that 'ACCOUNT DELETED!' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(aePage.deleteAccountPageDeleteBaslik.isDisplayed(),"Verify that 'ACCOUNT DELETED!' is not visible");
        extentTest.pass("'ACCOUNT DELETED!' is visible.");
        softAssert.assertAll();

    }
}
