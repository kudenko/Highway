package lesson3.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Imdb {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }


    @Test
    public void testBrowserNavigation()  {
        driver.get("https://www.imdb.com/title/tt0111161/");
        //1. Название фильма
        //2. Дата выхода
        //3. Продолжительность фильма в минутах. Продолжительность фильма в секундах.
        //4. Рейтинг фильма
        //5. Жанр
        //6. Ссылку на трейлер фильма
        //7. Ссылку на постер фильма
        //8. Директора фильма
        //9. 5 Актеров фильма
        //10. Рейтинг Metascore
        //11. Кол-во ревью (отдельно пользовательских, отдельно критиков, сумму пользовательских и критиков)
        //12. Названия 3х "похожих" фильмов
        System.out.println("Название фильма " + driver.findElement(By.xpath("//*[@class='title_wrapper']/h1")).getText());
        System.out.println("Дата выхода " + driver.findElement(By.xpath("//*[@id='titleYear']")).getText());
        System.out.println("Продолжительность фильма в минутах. " + driver.findElement(By.xpath("//*[@class='txt-block']//time[@datetime='PT142M']")).getText() + "" +
                " Продолжительность фильма в секундах. " + Integer.parseInt(driver.findElement(By.xpath("//*[@class='txt-block']//time[@datetime='PT142M']")).getText().substring(0,3)) * 60);
        System.out.println("Рейтинг фильма " + driver.findElement(By.xpath("//*[@itemprop='ratingValue']")).getText());
        System.out.println("Жанр " + driver.findElement(By.xpath("//*[@class='subtext']/a[@href][1]")).getText());
        System.out.println("Ссылку на трейлер фильма " + driver.findElement(By.xpath("//*[@class='slate']/a")).getAttribute("href"));
        System.out.println("Ссылку на постер фильма " + driver.findElement(By.xpath("//*[@class='slate']//img")).getAttribute("src"));
        System.out.println("Директора фильма " + driver.findElement(By.xpath("//*[@class='credit_summary_item'][1]//a")).getText());
        List<WebElement> actors = driver.findElements(By.xpath("//*[@class='cast_list']//td[2]"));
        for (int i=0; i<5; i++){
            System.out.println("Актер " + actors.get(i).getText());
        }
        int users = Integer.parseInt(driver.findElement(By.xpath("//*[@class='titleReviewBarItem titleReviewbarItemBorder']//a[1]")).getText().replaceAll("[^\\d]", "" ));
        int critics = Integer.parseInt(driver.findElement(By.xpath("//*[@class='titleReviewBarItem titleReviewbarItemBorder']//a[2]")).getText().replaceAll("[^\\d]", "" ));
        System.out.println("Рейтинг Metascore " + driver.findElement(By.xpath("//*[@class='metacriticScore score_favorable titleReviewBarSubItem']/span")).getText());
        System.out.println("Кол-во ревью  пользовательских " + users);
        System.out.println("Кол-во ревью критиков " + critics);
        System.out.println("Кол-во ревью  пользовательских и критиков " + (users + critics));

        List<WebElement> films = driver.findElements(By.xpath("//*[@class='rec_item']/a/img"));
        for (int i=0; i<3; i++){
            System.out.println("Похожее кино: " + films.get(i).getAttribute("alt"));
        }



    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

