package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookRegistration extends BaseTest{
    @Test
    public void go(){
        driver.get("https://www.facebook.com/");
        WebElement name = driver.findElement(By.xpath("//*[@name='firstname']"));
        WebElement serName = driver.findElement(By.xpath("//*[@name='lastname']"));
        WebElement number = driver.findElement(By.xpath("//*[@name='reg_email__']"));
        WebElement pass = driver.findElement(By.xpath("//*[@name='reg_passwd__']"));

        WebElement sex = driver.findElement(By.xpath("//*[@name='sex']"));
        WebElement button = driver.findElement(By.xpath("//*[@name='websubmit']"));
        Select selectDay = new Select(driver.findElement(By.xpath("//*[@name='birthday_day']")));
        Select selectMonth = new Select(driver.findElement(By.xpath("//*[@name='birthday_month']")));
        Select selectYear = new Select(driver.findElement(By.xpath("//*[@name='birthday_year']")));

    }
}
