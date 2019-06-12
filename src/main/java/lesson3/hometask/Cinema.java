package lesson3.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cinema {
    //Написать программу которая будет отображать кол-во мест в зале кинотеатра:
    //
    //Кол-во мест в зале
    //Кол-во мест занятых
    //Кол-во мест свободных
    //% Занятых мест от “всего мест в зале”
    //% Свободных мест от “всего мест в зале”
    //
    //Что делает программа:
    //
    //Переходим на http://liniakino.com/showtimes/aladdin/
    //Выбираем фильм “Дамбо” - ближайший сеанс.
    //Открываем схему зала
    //Считаем места
    //Выводим результат в консоль

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void testBrowserNavigation() throws InterruptedException {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        driver.findElement(By.xpath("//a[contains(@href,'/movies/?id=7531')]/../..//*[@class='showtime-item']/a")).click();
        Thread.sleep(4000);
        WebElement frame = driver.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@class='window-close arcticmodal-close']")).click();
        Thread.sleep(1000);

        int freePlaces = driver.findElements(By.xpath("//*[@class='seat seat-color1']")).size();
        int bookPlaces = driver.findElements(By.xpath("//*[@class='seat seat-occupied']")).size();
        int allPlaces = freePlaces + bookPlaces;
        System.out.println("Free places: " + freePlaces);
        System.out.println("Booked places: " + bookPlaces);

        System.out.println("All places: " + allPlaces);
        System.out.println("% free places " + (double)freePlaces/allPlaces * 100);
        System.out.println("% booked places " + (double)bookPlaces/allPlaces * 100);


    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

