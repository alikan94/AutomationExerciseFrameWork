package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestCase01 extends BaseTest {

    @Test
    public void signUpAndDeleteAccountTest(){
        //4. Click on 'Signup / Login' button
        homePage.signUpHeader.click();
        //5. Verify 'New User Signup!' is visible
        softAssert.assertTrue(homePage.newUserSignupBasligi.isDisplayed());

        //6. Enter name and email address
        ReusableMethods.waitFor(2);
        homePage.newUserSignupUserNameTextBox.sendKeys(faker.name().name());
        homePage.newUserSignupEmailTextBox.sendKeys(faker.internet().emailAddress());
        //7. Click 'Signup' button
        homePage.newUserSignupButton.click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        softAssert.assertTrue(homePage.newUserSignupEnterAccountBaslik.isDisplayed());


        //9. Fill details: Title, Name, Email, Password, Date of birth
        homePage.newUserSignupMrRadioButton.click();
        homePage.newUserSignupPasswordTextBox.sendKeys(ConfigReader.getProperty("aeValidPassword"));
        homePage.newUserSignupBirthDateDay.sendKeys("12");
        homePage.newUserSignupBirthDateMonth.sendKeys("o");
        homePage.newUserSignupBirthDateYear.sendKeys("1994");
        //10. Select checkbox 'Sign up for our newsletter!'
        homePage.newUserSignupNewsletterCheckBox.click();
        //11. Select checkbox 'Receive special offers from our partners!'
        homePage.newUserSignupOfferCheckBox.click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode,
        // Mobile Number
        //13. Click 'Create Account button'
        Actions actions = new Actions(Driver.getDriver());
        actions.click(homePage.newUserSignupAdressFirstName)
                .sendKeys("aaa")    // firstname
                .sendKeys(Keys.TAB)
                .sendKeys("aaa")    // lastname
                .sendKeys(Keys.TAB)
                .sendKeys("aaa")    // company
                .sendKeys(Keys.TAB)
                .sendKeys("aaa")    // adress1
                .sendKeys(Keys.TAB)
                .sendKeys("aaa")    // adress2
                .sendKeys(Keys.TAB)
                .sendKeys("u")    // Country
                .sendKeys(Keys.TAB)
                .sendKeys("aaa")    // state
                .sendKeys(Keys.TAB)
                .sendKeys("aaa")    // city
                .sendKeys(Keys.TAB)
                .sendKeys("35250")    // zipcode
                .sendKeys(Keys.TAB)
                .sendKeys("12345678")    // Mobilephpne
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        softAssert.assertTrue(homePage.newUserSignupAccountCreatedBaslik.isDisplayed());

        //15. Click 'Continue' button
        ReusableMethods.waitFor(2);
        homePage.newUserSignupAccountCreatedContinue.click();
        //16. Verify that 'Logged in as username' is visible
        softAssert.assertTrue(homePage.loggedInAsUserNameHeader.isDisplayed());


        //17. Click 'Delete Account' button
        ReusableMethods.waitFor(2);
        homePage.deleteAccountHeader.click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(homePage.deleteAccountPageDeleteBaslik.isDisplayed(),"Verify that 'ACCOUNT DELETED!' is not visible");
    }
}
