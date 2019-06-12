package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LiniyaKino extends BaseTest {

    @Test
    public void go(){
        driver.get("http://liniakino.com/showtimes/aladdin/");
        List<WebElement> films = driver.findElements(By.xpath("//li[@class='showtime-movie']//h1/a"));
        System.out.println("Список фильмов в Алладине:\n");
        films.forEach(a-> System.out.println(a.getText()));
    }
}
