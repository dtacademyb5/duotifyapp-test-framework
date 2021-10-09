package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

public class TestBase {


    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }

}
