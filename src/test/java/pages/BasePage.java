package pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BasePage {
    public WebDriverWait wait;

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    }



    //Wait Wrapper Method
    public void waitVisibility(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    //Click Method
    public void click (WebElement webElement) {
        waitVisibility(webElement);
        webElement.click();
    }
    public <T> T click (T t,WebElement webElement) {

        waitVisibility(webElement);
        webElement.click();

        return t;
    }

    //Write Text
    public <T> T writeText(T t, WebElement webElement, String text) {

        waitVisibility(webElement);
        webElement.sendKeys(text);

        return t;
    }

    //Read Text
    public String readText (WebElement webElement) {
        waitVisibility(webElement);
        return webElement.getText();
    }

    //Assert
    public void assertEquals (WebElement webElement, String expectedText) {
        waitVisibility(webElement);
        Assert.assertEquals(readText(webElement), expectedText);
    }

    // is visible
    public BasePage assertThatIsVisible(WebElement webElement){
        waitVisibility(webElement);
        assertTrue(webElement.isDisplayed());
        return new BasePage();
    }

}
