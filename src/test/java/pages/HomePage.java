package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='logo pull-left']")
    public WebElement logo;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement signUpHeader;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignupBasligi;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement newUserSignupUserNameTextBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement newUserSignupEmailTextBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newUserSignupButton;

    @FindBy(xpath = "//h2[@class='title text-center'][1]")
    public WebElement newUserSignupEnterAccountBaslik;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement newUserSignupMrRadioButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement newUserSignupPasswordTextBox;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement newUserSignupBirthDateDay;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement newUserSignupBirthDateMonth;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement newUserSignupBirthDateYear;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newUserSignupNewsletterCheckBox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement newUserSignupOfferCheckBox;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement newUserSignupAdressFirstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement newUserSignupAdressLastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement newUserSignupAdressCompany;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement newUserSignupAdressAdress1;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement newUserSignupAdressAdress2;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement newUserSignupAdressCountry;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement newUserSignupAccountCreatedBaslik;

    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement newUserSignupAccountCreatedContinue;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedInAsUserNameHeader;

    @FindBy(xpath = "//*[text()=' Delete Account']")
    public WebElement deleteAccountHeader;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteAccountPageDeleteButton;

    @FindBy(xpath = "//div[@class='page-header']")
    public WebElement deleteAccountPageDeleteBaslik;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountTitle;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginUserNameTextBox;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPasswordTextBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement loginErrorText;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement signupErrorText;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement logoutButtonHeader;

    @FindBy(xpath = "//a[text()=' Contact us']")
    public WebElement contactUsHeaderButton;

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement contactPageGetInTouchTitle;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement contactPageNameTextBox;

    @FindBy(xpath = "//input[@class='btn btn-primary pull-left submit_form']")
    public WebElement contactPageSubmitButton;

    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement contactPageUploadButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement contactPageSuccessMessage;

    @FindBy(xpath = "//span[text()=' Home']")
    public WebElement contactPageSuccessMessageHomeButton;

    @FindBy(xpath = "(//i[@class='fa fa-list'])[1]")
    public WebElement testCasesHeaderButton;

    @FindBy(xpath = "//b[text()='Test Cases']")
    public WebElement testCasesPageTitle;

    @FindBy(xpath = "//a[text()=' Products']")
    public WebElement productsHeaderButton;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscriptionFooterTitle;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement subscriptionEmailTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement subscriptionButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement subscriptionSuccessAlert;




    //**********-----------Methods------------**********//
    public HomePage signIn() {

        return new HomePage();
    }


    @Step("User scrolled down to footer.")
    public HomePage scrollDownToFooter() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        return new HomePage();
    }

    @Step("Web element gorunur mu bakildi.")
    public HomePage assertThatIsVisible(WebElement webElement){
        waitVisibility(webElement);
        assertTrue(webElement.isDisplayed());
        return new HomePage();
    }



}
