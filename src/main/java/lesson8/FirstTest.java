package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
    public static WebDriver driver;
    public static void main(String[] args) {
            driver = new ChromeDriver();
            driver.get("http://google.com");
    }

    @Test
    public void gogo(){
        driver = new ChromeDriver();
        driver.get("https://ukr.net");
        driver.quit();
    }
}
