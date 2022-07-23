package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ProductsPage extends BasePage{

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement allProductsTitle;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    public List<WebElement> allProductsList;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    public List<WebElement> productInfoTextCenterList;

    @FindBy(xpath = "(//a[text()='View Product'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//input[@class='form-control input-lg']")
    public WebElement searchTextBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElement searchButton;

    public boolean allProductsAreVisible(){
        boolean flag = true;

        for (WebElement w: allProductsList
             ) {
            try {
                ReusableMethods.waitForVisibility(w,5);
                ReusableMethods.hover(w);
                flag = w.isDisplayed();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
        return flag;
    }

}
