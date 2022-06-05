package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestCase01 extends IlkUcMaddeTesti{

    private String dateGetir(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        return date.format(formatters);
    }


    @Test
    public void signUpTest(){
        //4. Click on 'Signup / Login' button
        aePage.signUpHeader.click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(aePage.newUserSignupBasligi.isDisplayed());
    }

    @Test (dependsOnMethods = "signUpTest")
    public void signUpButtonTest(){
        //6. Enter name and email address
        aePage.newUserSignupUserNameTextBox.sendKeys("ali");
        aePage.newUserSignupEmailTextBox.sendKeys("denemeMaili"+dateGetir()+"@gmail.com");
        //7. Click 'Signup' button
        aePage.newUserSignupButton.click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(aePage.newUserSignupEnterAccountBaslik.isDisplayed());
    }

    @Test (dependsOnMethods = "signUpButtonTest")
    public void createAccountTesti() {
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
        Assert.assertTrue(aePage.newUserSignupAccountCreatedBaslik.isDisplayed());
    }

    @Test (dependsOnMethods = "createAccountTesti")
    public void signUpContinueTesti() {
        //15. Click 'Continue' button
        aePage.newUserSignupAccountCreatedContinue.click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(aePage.loggedInAsUserNameHeader.isDisplayed());

    }

    @Test (dependsOnMethods = "signUpContinueTesti")
    public void deleteAccountTesti() {

        //17. Click 'Delete Account' button
        aePage.deleteAccountHeader.click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(aePage.deleteAccountPageDeleteBaslik.isDisplayed());
    }
}
