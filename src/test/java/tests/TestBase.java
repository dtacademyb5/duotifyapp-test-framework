package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.io.File;
import java.lang.reflect.Method;

public abstract class TestBase {


    protected WebDriver driver;

    //Extent report classes

    protected static ExtentReports report;  // manages the entire report
    protected static ExtentSparkReporter htmlReporter; // generates the html report
    protected static ExtentTest logger; // adding logs to our tests





    @BeforeSuite
    public void setupSuite(){
        report = new ExtentReports();

        String path =  System.getProperty("user.dir") + "/test-output/extentReports/index.html";
        htmlReporter = new ExtentSparkReporter(path);
        report.attachReporter(htmlReporter);

        // Configuration settings

        report.setSystemInfo("Tester", "John Doe");
        report.setSystemInfo("Environment", "QA_ENV");
        report.setSystemInfo("Browser", ConfigReader.getProperty("browser"));



    }

    @BeforeMethod

    public void setup(Method method){

        driver = Driver.getDriver();

        logger = report.createTest(method.getName());
    }





    @AfterMethod
    public void teardown(ITestResult testResult){


        if(testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("Test passed: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.SKIP){
            logger.skip("Test skipped: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.FAILURE){
            logger.fail("Test Failed: "  + testResult.getName());
            logger.fail(testResult.getThrowable());
            logger.addScreenCaptureFromPath(SeleniumUtils.getScreenshot("failed"));
        }


        Driver.quitDriver();


    }


    @AfterSuite
    public void tearDown(){
          report.flush(); //write the report to file
    }

}
