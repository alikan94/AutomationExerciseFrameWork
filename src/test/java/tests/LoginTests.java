package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestListener;


@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {
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

    @Test (priority = 0, description = "Login User With Correct Email And Password")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: User cab login with correct email and password.")
    @Story("Correct email and password test")
    public void loginAndDeleteAccountTest() {
/*
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
 */
        // first three steps are done at the parent class

        extentTest=extentReports.createTest("TC002_LoginUserWithCorrectEmailAndPassword",
                "User can login with correct email and password");

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        softAssert.assertTrue(homePage.logo.isDisplayed());
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
        softAssert.assertAll();

    }

    /*

    TC003_LoginUserWithIncorrectEmailAndPassword
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter incorrect email address and password
            7. Click 'login' button
            8. Verify error 'Your email or password is incorrect!' is visible
     */

    @Test (priority = 1, description = "Login User With Incorrect Email And Password")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Incorrect email and password test")
    @Description("Test Description: User can not login with incorrect email and password.")
    public void LoginUserWithIncorrectEmailAndPasswordTest() {
        extentTest=extentReports.createTest("TC003_LoginUserWithIncorrectEmailAndPassword",
                "User can not login with incorrect email and password");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        /* first three steps are done at the parent class*/

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(homePage.logo.isDisplayed());
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
        softAssert.assertAll();

    }
    /*
            Test Case 4: Logout User
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'Login to your account' is visible
            6. Enter correct email address and password
            7. Click 'login' button
            8. Verify that 'Logged in as username' is visible
            9. Click 'Logout' button
            10. Verify that user is navigated to login page
     */

    @Test (priority = 2, description = "User can logout")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Logout User Test")
    @Description("Test Description: User can logout")
    public void LogoutUserTest() {

        extentTest=extentReports.createTest("TC04_LogoutUserTest",
                "User can logout");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        /* first three steps are done at the parent class*/
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(homePage.logo.isDisplayed());
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

        //9. Click 'Logout' button
        homePage.logoutButtonHeader.click();
        extentTest.info("Clicked to login button on the login page.");

        //10. Verify that user is navigated to login page
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.loginToYourAccountTitle.isDisplayed());
        extentTest.pass("User is navigated to login page.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
