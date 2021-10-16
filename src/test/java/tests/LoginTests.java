package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTests extends TestBase{



    @Test
    public void positiveLoginPageObjectModelStyle(){



        logger.info("Navigate to homepage");
        driver.get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        logger.info("Enter Username");
        loginPage.username.sendKeys(ConfigReader.getProperty("username"));
        logger.info("Enter Password");
        loginPage.password.sendKeys(ConfigReader.getProperty("password"));
        logger.info("Log in");
        loginPage.loginButton.click();

        logger.info("Assert the title");

        Assert.assertTrue(driver.getTitle().contains("Welcome"));







    }

    @Test
    public void negativeLogin(){

        logger.info("Navigate to homepage");
        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("loginUsername")).sendKeys("bc dsb ");
        driver.findElement(By.id("loginPassword")).sendKeys("bbdhsbchbd");
        driver.findElement(By.name("loginButton")).click();
        logger.info("Assert the title");
        Assert.assertTrue(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.ph?"));
    }


    @Test
    public void negativeLogin2(){


        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("loginUsername")).sendKeys("bc dsb ");
        driver.findElement(By.id("loginPassword")).sendKeys("bbdhsbchbd");
        driver.findElement(By.name("loginButton")).click();
        throw new SkipException("skipped");
//        Assert.assertFalse(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
    }



}
