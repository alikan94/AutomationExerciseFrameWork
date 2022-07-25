package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class TestCase10 extends BaseTest{

    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Scroll down to footer
            5. Verify text 'SUBSCRIPTION'
            6. Enter email address in input and click arrow button
            7. Verify success message 'You have been successfully subscribed!' is visible
     */

    HomePage homePage = new HomePage();

    @Test
    public void VerifySubscriptionInHomePage() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Scroll down to footer
        //5. Verify text 'SUBSCRIPTION'
        //6. Enter email address in input and click arrow button
        //7. Verify success message 'You have been successfully subscribed!' is visible

        homePage
                .scrollDownToFooter()       // 4. Scroll down to footer
                .assertThatIsVisible(homePage.subscriptionFooterTitle)  //5. Verify text 'SUBSCRIPTION'
                .writeText(homePage,homePage.subscriptionEmailTextBox,faker.internet().emailAddress()) //6. Enter email address in input
                .click(homePage,homePage.subscriptionButton)        //6. Click arrow button
                .assertThatIsVisible(homePage.subscriptionSuccessAlert); //7. Verify success message 'You have been successfully subscribed!' is visible

    }
}
