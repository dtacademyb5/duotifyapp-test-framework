package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage extends PageBase{


   /*
      This framework uses Page Object Model which is a common design pattern for Selenium based frameworks
      Page Object Model is implemented by creating page classes for each page of our application and then adding
      storing the page elements within that class.
      Page Object Model is used for re-usabilty, mainatainability and readability
    */




   // PageFactory class must be used for @FindBy to work



   @FindBy (id = "hideLogin")
   public WebElement link;

      //Example of a Page Object Model without using PageFactory class and FindBy annotations
//   public WebElement link = Driver.getDriver().findElement(By.id("hideLoginLink"));

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
