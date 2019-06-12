package lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DriverImplicityWait extends BaseTest {
    @Test
    public void pageLoad(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//только для pageLoad
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//ждет элемент 30 минут Неявные для всех
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);//выполнение скрипта
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("google.com"));

    }
}
