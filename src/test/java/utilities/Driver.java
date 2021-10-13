package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    /*
      This utility class is used to control the initialization of a WebDriver.
      This class uses Singleton design pattern, because we need a single instance of a WebDriver at any point during
      the execution of our tests.
      Because it is a common issue in testing frameworks to accidentally initialize multiple WebDrivers which leads to test failures.
      Singleton pattern prevents that issue.
     */

    private static WebDriver driver;

    private Driver(){}


    public static WebDriver getDriver(){

        if(driver == null){

        String browserType = ConfigReader.getProperty("browser");

           switch (browserType){

               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               case "safari":
                   WebDriverManager.safaridriver().setup();
                   driver = new SafariDriver();
                   break;
               case "chromeHeadless":
                   ChromeOptions chromeOptions = new ChromeOptions();
                   chromeOptions.setHeadless(true);
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver(chromeOptions);
                   break;
               case "firefoxHeadless":
                   FirefoxOptions firefoxOptions = new FirefoxOptions();
                   firefoxOptions.setHeadless(true);
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver(firefoxOptions);
                   break;
               case "edgeHeadless":
                   EdgeOptions edgeOptions = new EdgeOptions();
                   edgeOptions.addArguments("headless");
                   edgeOptions.addArguments("disable-gpu");
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver(edgeOptions);
                   break;
               default:
                   System.out.println("Invalid driver");
                   break;

           }


        }

        return driver;


    }


    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null; // quitting does not make driver null;
        }
    }



}
