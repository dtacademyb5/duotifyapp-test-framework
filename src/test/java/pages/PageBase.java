package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class PageBase {

    /*
       This class is used to store common elements for all pages
       For example, header and footer elements that are common for all pages could be stored here
     */

    public PageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
