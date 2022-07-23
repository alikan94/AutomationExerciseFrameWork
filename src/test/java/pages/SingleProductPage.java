package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SingleProductPage extends BasePage{

    public SingleProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//h2[text()='Blue Top']")
    public WebElement firstProductName;

    @FindBy(xpath = "//p[text()='Category: Women > Tops']")
    public WebElement firstProductCategory;

    @FindBy(xpath = "//span[text()='Rs. 500']")
    public WebElement firstProductPrice;

    @FindBy(xpath = "//b[text()='Availability:']")
    public WebElement firstProductAvailability;

   @FindBy(xpath = "//b[text()='Condition:']")
    public WebElement firstProductCondition;

    @FindBy(xpath = "//b[text()='Brand:']")
    public WebElement firstProductBrand;

}
