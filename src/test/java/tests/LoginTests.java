package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class LoginTests extends TestBase{



    @Test
    public void positiveLogin(){
        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("loginUsername")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.id("loginPassword")).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(By.name("loginButton")).click();
        Assert.assertTrue(driver.getTitle().contains("Welcome"));
    }

    @Test
    public void negativeLogin(){
        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("loginUsername")).sendKeys("bc dsb ");
        driver.findElement(By.id("loginPassword")).sendKeys("bbdhsbchbd");
        driver.findElement(By.name("loginButton")).click();
        Assert.assertFalse(driver.getCurrentUrl().equals("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
    }



}
