package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

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

    //Write Text
    public void writeText (WebElement webElement, String text) {
        waitVisibility(webElement);
        webElement.sendKeys(text);
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

}
