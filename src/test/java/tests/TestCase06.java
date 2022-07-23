package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase06 extends BaseTest {
    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Contact Us' button
            5. Verify 'GET IN TOUCH' is visible
            6. Enter name, email, subject and message
            7. Upload file
            8. Click 'Submit' button
            9. Click OK button
            10. Verify success message 'Success! Your details have been submitted successfully.' is visible
            11. Click 'Home' button and verify that landed to home page successfully
     */

    //SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void ContactUsFormTest(){
        extentTest=extentReports.createTest("TC04_ContactUsFormTest",
                "Contact Us Form Test");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        /* first three steps are done at the parent class*/
        extentTest.info("Navigated to AE website homepage.");

        //4. Click on 'Contact Us' button
        homePage.contactUsHeaderButton.click();
        extentTest.info("Clicked on 'Contact Us' button.");

        //5. Verify 'GET IN TOUCH' is visible
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.contactPageGetInTouchTitle.isDisplayed());
        extentTest.pass("'GET IN TOUCH' title is visible.");

        //6. Enter name, email, subject and message
        actions.click(homePage.contactPageNameTextBox)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.book().title())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        //7. Upload file
        homePage.contactPageUploadButton.sendKeys("C:\\Users\\alika\\IdeaProjects\\com.AE_UITesting\\src\\test\\java\\uploadtestfile.txt");
        extentTest.info("Uploaded a file.");

        //8. Click 'Submit' button
        ReusableMethods.waitFor(2);
        homePage.contactPageSubmitButton.click();
        extentTest.info("Clicked 'Submit' button.");

        //9. Click OK button
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("Clicked OK button on the JS alert.");

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        ReusableMethods.waitFor(1);
        String expectedMessage = "Success! Your details have been submitted successfully.";
        String actualMessage = homePage.contactPageSuccessMessage.getText();
        softAssert.assertEquals(actualMessage,expectedMessage,"Title is not true or not visible");
        extentTest.pass("Success message 'Success! Your details have been submitted successfully.' is visible.");

        //11. Click 'Home' button and verify that landed to home page successfully
        homePage.contactPageSuccessMessageHomeButton.click();
        ReusableMethods.waitFor(1);
        extentTest.info("Clicked 'Home' button.");
        softAssert.assertTrue(homePage.logo.isDisplayed());
        extentTest.pass("Landed to home page successfully.");
        //softAssert.assertAll();

    }
}
