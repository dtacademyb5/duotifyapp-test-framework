package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {

   // PageFactory class must be used for @FindBy to work

   public SignUpPage(){
      PageFactory.initElements(Driver.getDriver(), this);
   }

   @FindBy (id = "hideLoginLink")
   public WebElement link;

   @FindBy (id = "username")
   public WebElement usernameField;

   @FindBy (id = "firstName")
   public WebElement firstName;

   @FindBy (id = "lastName")
   public WebElement lastName;

   @FindBy (id = "email")
   public WebElement email1;

   @FindBy (id = "email2")
   public WebElement email2;

   @FindBy (id = "password")
   public WebElement password;


   @FindBy (id = "password2")
   public WebElement password2;


   @FindBy (name = "registerButton")
   public WebElement registerButton;







}
