package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTests extends TestBase{


    // How do you run parallel test TestNG framework?

    // I use parallel attribute in TestNG xml file and I set it to "classes" to run methods in classes in parallel
    // and also indicate the amount of threads with thread-count attribute




    @Test
    public void googleSearchTest(){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("iphone 13" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("iphone 13"));



    }


    @Test
    public void googleSearchTest2(){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("iphone 13" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("iphone 13"));


    }


    @Test
    public void googleSearchTest3(){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("iphone 13" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("iphone 13"));


    }

    @Test
    public void googleSearchTest4(){


        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("iphone 13" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("iphone 13"));


    }
}
