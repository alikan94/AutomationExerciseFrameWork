package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class AePage {

    public AePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div[@class='logo pull-left']")
    public WebElement logo;

    @FindBy (xpath = "//i[@class='fa fa-lock']")
    public WebElement signUpHeader;

    @FindBy (xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignupBasligi;

    @FindBy (xpath = "//input[@data-qa='signup-name']")
    public WebElement newUserSignupUserNameTextBox;

    @FindBy (xpath = "//input[@data-qa='signup-email']")
    public WebElement newUserSignupEmailTextBox;

    @FindBy (xpath = "//button[@data-qa='signup-button']")
    public WebElement newUserSignupButton;

    @FindBy (xpath = "//h2[@class='title text-center'][1]")
    public WebElement newUserSignupEnterAccountBaslik;

    @FindBy (xpath = "//input[@id='id_gender1']")
    public WebElement newUserSignupMrRadioButton;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement newUserSignupPasswordTextBox;

    @FindBy (xpath = "//select[@id='days']")
    public WebElement newUserSignupBirthDateDay;

    @FindBy (xpath = "//select[@id='months']")
    public WebElement newUserSignupBirthDateMonth;

    @FindBy (xpath = "//select[@id='years']")
    public WebElement newUserSignupBirthDateYear;

    @FindBy (xpath = "//input[@id='newsletter']")
    public WebElement newUserSignupNewsletterCheckBox;

    @FindBy (xpath = "//input[@id='optin']")
    public WebElement newUserSignupOfferCheckBox;

    @FindBy (xpath = "//input[@id='first_name']")
    public WebElement newUserSignupAdressFirstName;

    @FindBy (xpath = "//input[@id='last_name']")
    public WebElement newUserSignupAdressLastName;

    @FindBy (xpath = "//input[@id='company']")
    public WebElement newUserSignupAdressCompany;

    @FindBy (xpath = "//input[@id='address1']")
    public WebElement newUserSignupAdressAdress1;

    @FindBy (xpath = "//input[@id='address2']")
    public WebElement newUserSignupAdressAdress2;

    @FindBy (xpath = "//select[@id='country']")
    public WebElement newUserSignupAdressCountry;

    @FindBy (xpath = "//*[text()='Account Created!']")
    public WebElement newUserSignupAccountCreatedBaslik;

    @FindBy (xpath = "//*[text()='Continue']")
    public WebElement newUserSignupAccountCreatedContinue;

    @FindBy (xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedInAsUserNameHeader;

    @FindBy (xpath = "//*[text()=' Delete Account']")
    public WebElement deleteAccountHeader;

    @FindBy (xpath = "//button[text()='Delete']")
    public WebElement deleteAccountPageDeleteButton;

    @FindBy (xpath = "//h1=[text()='Delete Account']")
    public WebElement deleteAccountPageDeleteBaslik;


}
