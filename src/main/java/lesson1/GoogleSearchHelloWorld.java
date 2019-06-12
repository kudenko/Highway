package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchHelloWorld {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.findElement(By.cssSelector("[name='q']")).clear();
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Hello, world");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".g h3")).click();
        System.out.println("Title" + driver.getTitle());
        Thread.sleep(5000);
        driver.quit();

    }
}
