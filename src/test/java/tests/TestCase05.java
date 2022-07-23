package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class TestCase05 extends BaseTest {
    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Signup / Login' button
            5. Verify 'New User Signup!' is visible
            6. Enter name and already registered email address
            7. Click 'Signup' button
            8. Verify error 'Email Address already exist!' is visible
     */

    //SoftAssert softAssert = new SoftAssert();

    @Test
    public void registerUserWithExistingEmailTest() {
        extentTest=extentReports.createTest("TC05_RegisterUserWithExistingEmailTest",
                "User can not register with Existing Email");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        /* first three steps are done at the parent class*/
        extentTest.info("Navigated to AE website homepage.");

        //4. Click on 'Signup / Login' button
        ReusableMethods.waitFor(2);
        homePage.signUpHeader.click();
        extentTest.info("Clicked to login button on the header.");

        //5. Verify 'New User Signup!' is visible
        softAssert.assertTrue(homePage.newUserSignupBasligi.isDisplayed());
        extentTest.pass("'New User Signup!' is visible.");

        //6. Enter name and already registered email address
        ReusableMethods.waitFor(2);
        homePage.newUserSignupUserNameTextBox.sendKeys(faker.name().name());
        homePage.newUserSignupEmailTextBox.sendKeys(ConfigReader.getProperty("aeValidMail"));
        extentTest.info("Entered name and already registered email address.");

        //7. Click 'Signup' button
        homePage.newUserSignupButton.click();
        extentTest.info("Clicked 'Signup' button.");

        //8. Verify error 'Email Address already exist!' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.signupErrorText.isDisplayed());
        extentTest.pass("'Your email or password is incorrect!' is visible");
        //softAssert.assertAll();

    }
}
