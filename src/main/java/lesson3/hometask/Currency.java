package lesson3.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Currency {
    //Написать программу которая будет:
    //
    //1. Заходить на сайты банков
    //2. Записывать 2 переменные типа "double" - курс покупки\продажи валют (гривна\доллар)
    //3. Посчитать средний курс валют, отдельно, покупки и продажи между всеми банками (вывести в консоль)
    //4. Вывести в консоль банк с самым низким курсом покупки доллара
    //5. Вывести в консоль банк с самым высоким курсом продажи
    //
    //Список сайтов:
    //https://www.privat24.ua
    //https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/
    //https://www.universalbank.com.ua/
    //http://www.oschadbank.ua/ua/
    //http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily (НБУ)

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }


    @Test
    public void testBrowserNavigation() {
        List<Banks> banks = new ArrayList<Banks>();
        Banks bank = new Banks();
        bank.setUrl("https://www.privat24.ua");
        bank.setName("Privat");
        driver.get(bank.getUrl());
        String currency[] = driver.findElement(By.xpath("(//*[@class='section-content rate'])[1]")).getText().split("/");
        bank.setBuy(Double.parseDouble(currency[0].trim()));
        bank.setSell(Double.parseDouble(currency[1].trim()));
        banks.add(bank);

        bank = new Banks();
        bank.setUrl("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        bank.setName("Ukrsibbank");
        driver.get(bank.getUrl());
        bank.setBuy(Double.parseDouble(driver.findElement(By.xpath("//*[@class='currency__wrapper']//tbody//td[2]")).getText()));
        bank.setSell(Double.parseDouble(driver.findElement(By.xpath("//*[@class='currency__wrapper']//tbody//td[3]")).getText()));
        banks.add(bank);

        bank = new Banks();
        bank.setUrl("https://www.universalbank.com.ua/");
        bank.setName("Universal Bank");
        driver.get(bank.getUrl());
        bank.setBuy(Double.parseDouble(driver.findElement(By.xpath("//div[contains(@class,'rate-table')]//tr[2]/td[2]")).getText()));
        bank.setSell(Double.parseDouble(driver.findElement(By.xpath("//div[contains(@class,'rate-table')]//tr[2]/td[3]")).getText()));
        banks.add(bank);

        bank = new Banks();
        bank.setUrl("http://www.oschadbank.ua/ua/");
        bank.setName("Oschad Bank");
        driver.get(bank.getUrl());
        bank.setBuy(Double.parseDouble(driver.findElement(By.xpath("//*[@class='buy-USD']")).getText()));
        bank.setSell(Double.parseDouble(driver.findElement(By.xpath("//*[@class='sell-USD']")).getText()));
        banks.add(bank);

        bank = new Banks();
        bank.setUrl("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        bank.setName("NBU");
        driver.get(bank.getUrl());
        bank.setBuy(Double.parseDouble(driver.findElement(By.xpath("//td[text()='Долар США']/following-sibling::td")).getText())/100);
        bank.setSell(Double.parseDouble(driver.findElement(By.xpath("//td[text()='Долар США']/following-sibling::td")).getText())/100);
        banks.add(bank);

        double avBuy = 0;
        double avSell = 0;

        for(Banks b:banks){
            avBuy += b.getBuy();
        }

        for(Banks b:banks){
            avSell += b.getSell();
        }

        System.out.println("Av sell " + avSell/banks.size());
        System.out.println(
                "Av buy " + avBuy/banks.size()
        );

        double minBuy = banks.stream().mapToDouble(a -> a.getBuy()).min().orElseThrow(IllegalStateException::new);
        double maxSell = banks.stream().mapToDouble(a -> a.getSell()).max().orElseThrow(IllegalAccessError::new);

        for (Banks b : banks) {
             if(minBuy == b.getBuy()){
                 System.out.println("Bank with min Buy " + b.getName() + " " + minBuy);
             }

        }
        for (Banks b : banks) {
            if(maxSell == b.getSell()){
                System.out.println("Bank with max Sell " + b.getName() + " " + maxSell);
            }

        }
    }







    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

