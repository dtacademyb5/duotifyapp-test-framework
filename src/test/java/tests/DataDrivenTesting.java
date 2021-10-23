package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CSVReader;
import utilities.ExcelUtils;

import java.util.Arrays;

public class DataDrivenTesting extends TestBase{


    // Data-Driven Testing - Running the same test with different set of data
    // In TestNG framework, we use DataProvider to implement DDT


    // How do you use test data?
    // I generate my own test data, using third party libraries and tools.



    @Test (dataProvider = "getData")
    public void googleSearchTest(String searchTerm){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));



    }




    @Test (dataProvider = "getData2")
    public void googleSearchTest2(String searchTerm){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));



    }


    @Test (dataProvider = "getData3")
    public void googleSearchTest3(String searchTerm){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));



    }



    @DataProvider
    public Object[][] getData(){

        return new Object[][]{
                {"iphone"},
                {"=r5bdVJobAanZK"},
                {"Олимпийский комитет России"},
                {"牛繁牛繁"},
                {"\uD83D\uDE01"},

        };
    }


    @DataProvider
    public Object[][] getData2(){

        return CSVReader.readData("data.csv");
    }


    @DataProvider
    public Object[][] getData3(){

        return new ExcelUtils("testDat.xlsx", "Sheet2").getDataAs2DArray();
    }



}
