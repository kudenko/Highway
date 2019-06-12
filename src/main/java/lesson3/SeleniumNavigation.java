package lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumNavigation {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void testBrowserNavigation() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(5000);

        driver.get("https://facebook.com");
        System.out.println("CURRENT URL: "+driver.getCurrentUrl());
        driver.navigate().back();
        Thread.sleep(5000);
        System.out.println("AFTER .back() URL: "+driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("AFTER .forward() URL: "+driver.getCurrentUrl());
        driver.quit();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
