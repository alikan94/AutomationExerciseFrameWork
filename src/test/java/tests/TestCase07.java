package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ReusableMethods;

public class TestCase07 extends IlkUcMaddeTesti{

    /*
            Test Case 7: Verify Test Cases Page
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Test Cases' button
            5. Verify user is navigated to test cases page successfully
     */

    SoftAssert softAssert = new SoftAssert();


    @Test
    public void VerifyTestCasesPageTest() {
        extentTest=extentReports.createTest("TC07_VerifyTestCasesPageTest",
                "Verify Test Cases Page");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        /* first three steps are done at the parent class*/
        extentTest.info("Navigated to AE website homepage.");

        //4. Click on 'Test Cases' button
        aePage.testCasesHeaderButton.click();
        extentTest.info("Click on 'Test Cases' button.");

        //5. Verify user is navigated to test cases page successfully
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(aePage.testCasesPageTitle.isDisplayed());
        extentTest.pass("User is navigated to test cases page successfully");
        softAssert.assertAll();

    }
}
