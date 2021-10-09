package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class SignUpTests extends TestBase{



    @Test
    public void positiveSignUp(){

        Faker faker = new Faker();

        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("hideLoginLink")).click();
        driver.findElement(By.id("username")).sendKeys(faker.name().username());
        driver.findElement(By.id("firstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email2")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("dt123");
        driver.findElement(By.id("password2")).sendKeys("dt123");
        driver.findElement(By.name("registerButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        Assert.assertTrue(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
    }

    @Test
    public void positiveSignUpPOMStyele(){

        Faker faker = new Faker();

        SignUpPage signUpPage = new SignUpPage();
        driver.get(ConfigReader.getProperty("url"));

        signUpPage.link.click();
        signUpPage.usernameField.sendKeys(faker.name().username());
        signUpPage.firstName.sendKeys(faker.name().firstName());
        signUpPage.lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        signUpPage.email1.sendKeys(email);
        signUpPage.email2.sendKeys(email);
        signUpPage.password.sendKeys("dt123");
        signUpPage.password2.sendKeys("dt123");
        signUpPage.registerButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        Assert.assertTrue(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
    }


    @Test
    public void negativeSignUp(){

        Faker faker = new Faker();

        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("hideLoginLink")).click();
        driver.findElement(By.id("username")).sendKeys("usr");
        driver.findElement(By.id("firstName")).sendKeys("usr");
        driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email2")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("dt123");
        driver.findElement(By.id("password2")).sendKeys("dt123");
        driver.findElement(By.name("registerButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Assert.assertFalse(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
    }


    @Test
    public void negativeSignUp2(){

        Faker faker = new Faker();

        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("hideLogin")).click();
        driver.findElement(By.id("username")).sendKeys("usr");
        driver.findElement(By.id("firstName")).sendKeys("usr");
        driver.findElement(By.id("lastName")).sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email2")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("dt123");
        driver.findElement(By.id("password2")).sendKeys("dt123");
        driver.findElement(By.name("registerButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        Assert.assertFalse(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
    }



}
