package ht1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Facebook {

        public static void main(String[] args) throws InterruptedException {
            //properties for deleting notifications
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            WebDriver driver = new ChromeDriver(options);

            Scanner scanner = new Scanner(System.in);
            driver.get("https://facebook.com");
            driver.findElement(By.cssSelector("[name='email']")).clear();
            System.out.println("Enter your name: ");
            String s = scanner.nextLine();
            driver.findElement(By.cssSelector("[name='email']")).sendKeys(s);
            driver.findElement(By.cssSelector("[name='pass']")).clear();
            System.out.println("Enter your pass: ");
            s = scanner.nextLine();
            driver.findElement(By.cssSelector("[name='pass']")).sendKeys(s);

            driver.findElement(By.cssSelector("[data-testid='royal_login_button']")).click();
            Thread.sleep(15000);
            driver.findElement(By.cssSelector("[data-testid='left_nav_item_Messenger']")).click();
            Thread.sleep(3000);
            System.out.println(driver.findElement(By.cssSelector("._aok")).getText());
            Thread.sleep(5000);
            driver.quit();
        }

        @Test
    public void test(){
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            System.out.println(a);
        }
}
