package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ImdbExample {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void testBrowserNavigation() throws InterruptedException {
        driver.get("https://www.imdb.com/chart/top");
        List<WebElement> titles = driver.findElements(By.xpath("//*[@class='titleColumn']//a"));
        for (WebElement t:titles
             ) {
            System.out.println(t.getText() + " \n");
        }

        List<WebElement> hrefs = driver.findElements(By.xpath("//*[@class='titleColumn']//a"));
        for (WebElement h:hrefs
        ) {
            System.out.println(h.getAttribute("href") + " \n");
        }

        List<WebElement> rating = driver.findElements(By.xpath("//*[@class='ratingColumn imdbRating']"));
        for (WebElement r:rating
        ) {
            System.out.println(r.getText() + " rating\n");
        }
    }

    @Test
    public void test(){

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
