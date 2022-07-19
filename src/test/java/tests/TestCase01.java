package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestCase01 extends IlkUcMaddeTesti{

    SoftAssert softAssert = new SoftAssert();

    private String dateGetir(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        return date.format(formatters);
    }


    @Test
    public void signUpAndDeleteAccountTest(){
        //4. Click on 'Signup / Login' button
        aePage.signUpHeader.click();
        //5. Verify 'New User Signup!' is visible
        softAssert.assertTrue(aePage.newUserSignupBasligi.isDisplayed());

        //6. Enter name and email address
        aePage.newUserSignupUserNameTextBox.sendKeys(faker.name().name());
        aePage.newUserSignupEmailTextBox.sendKeys(faker.internet().emailAddress());
        //7. Click 'Signup' button
        ReusableMethods.waitFor(2);
        aePage.newUserSignupButton.click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        softAssert.assertTrue(aePage.newUserSignupEnterAccountBaslik.isDisplayed());


        //9. Fill details: Title, Name, Email, Password, Date of birth
        aePage.newUserSignupMrRadioButton.click();
        aePage.newUserSignupPasswordTextBox.sendKeys("12345");
        aePage.newUserSignupBirthDateDay.sendKeys("12");
        aePage.newUserSignupBirthDateMonth.sendKeys("o");
        aePage.newUserSignupBirthDateYear.sendKeys("1994");
        //10. Select checkbox 'Sign up for our newsletter!'
        aePage.newUserSignupNewsletterCheckBox.click();
        //11. Select checkbox 'Receive special offers from our partners!'
        aePage.newUserSignupOfferCheckBox.click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode,
        // Mobile Number
        //13. Click 'Create Account button'
        Actions actions = new Actions(Driver.getDriver());
        actions.click(aePage.newUserSignupAdressFirstName)
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
        softAssert.assertTrue(aePage.newUserSignupAccountCreatedBaslik.isDisplayed());

        //15. Click 'Continue' button
        ReusableMethods.waitFor(2);
        aePage.newUserSignupAccountCreatedContinue.click();
        //16. Verify that 'Logged in as username' is visible
        softAssert.assertTrue(aePage.loggedInAsUserNameHeader.isDisplayed());


        //17. Click 'Delete Account' button
        ReusableMethods.waitFor(2);
        aePage.deleteAccountHeader.click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(aePage.deleteAccountPageDeleteBaslik.isDisplayed(),"Verify that 'ACCOUNT DELETED!' is visible");
        softAssert.assertAll();
    }
}
