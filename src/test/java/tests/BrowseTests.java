package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrowsePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BrowseTests extends TestBase{




    @Test
    public void positiveLogin(){
        driver.get(ConfigReader.getProperty("url"));
        driver.findElement(By.id("loginUsername")).sendKeys(ConfigReader.getProperty("username"));
        driver.findElement(By.id("loginPassword")).sendKeys(ConfigReader.getProperty("password"));
        driver.findElement(By.name("loginButton")).click();
        Assert.assertTrue(driver.getTitle().contains("Welcome"));
    }

    @Test
    public void verifyAlbumNames(){

        driver.get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys("duotech");
        loginPage.password.sendKeys("duotech");
        loginPage.loginButton.click();
        List<String> expectedList = Arrays.asList("Marisa", "Ultimatum",
                 "Escape", "Oscillation", "Werk", "Cruel Summer", "Fenix", "Clouds", "I Am...Sasha Fierce");

        List<String>  actualList =  SeleniumUtils.getElementsText(new BrowsePage().allAlbums);

          Collections.sort(expectedList);
          Collections.sort(actualList);
          Assert.assertEquals(actualList, expectedList);



    }

}
