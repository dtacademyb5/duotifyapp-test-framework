package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage extends PageBase {


    @FindBy (id = "loginUsername")
    public WebElement username;


    @FindBy (id = "loginPassword")
    public WebElement password;

    @FindBy (name = "loginButton")
    public WebElement loginButton;

}
