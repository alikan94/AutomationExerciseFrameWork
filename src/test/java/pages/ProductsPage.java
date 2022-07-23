package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductsPage extends BasePage{

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
