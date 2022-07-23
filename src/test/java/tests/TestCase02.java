package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TestCase02 extends BaseTest {
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

    //SoftAssert softAssert = new SoftAssert();

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
        homePage.signUpHeader.click();
        extentTest.info("Clicked to login button on the header.");
        //5. Verify 'Login to your account' is visible
        softAssert.assertTrue(homePage.loginToYourAccountTitle.isDisplayed());
        extentTest.pass("'Login To Your Account' title is displayed");
        //6. Enter correct email address and password
        homePage.loginUserNameTextBox.sendKeys(ConfigReader.getProperty("aeValidMail"));
        homePage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("aeValidPassword"));
        extentTest.info("Entered correct email address and password.");
        //7. Click 'login' button
        homePage.loginButton.click();
        extentTest.info("Clicked to login button on the login page.");
        //8. Verify that 'Logged in as username' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.loggedInAsUserNameHeader.isDisplayed());
        extentTest.pass("'Logged in as username' is visible.");

        //9. Click 'Delete Account' button
        homePage.deleteAccountHeader.click();
        extentTest.info("Clicked 'Delete Account' button.");

        //10. Verify that 'ACCOUNT DELETED!' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.deleteAccountPageDeleteBaslik.isDisplayed(),"Verify that 'ACCOUNT DELETED!' is not visible");
        extentTest.pass("'ACCOUNT DELETED!' is visible.");
        //softAssert.assertAll();

    }
}
