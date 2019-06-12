package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

public class SeleniumCheck {

    private static WebDriver driver;
    private By privateBank = By.xpath("//*[@class='section-content rate']");
    private By ukrsibBankBuy = By.xpath("//i[contains(text(),'доллар США')]//following::td[1]");
    private By ukrsibBankSell = By.xpath("//i[contains(text(),'доллар США')]//following::td[2]");
    private By universalBankBuy = By.xpath("//td[1][contains(text(),'USD')]//following::td[1]");
    private By universalBankSell = By.xpath("//td[1][contains(text(),'USD')]//following::td[2]");
    private By oshadBankBuy = By.xpath("//*[@class='buy-USD']");
    private By oshadBankSell = By.xpath("//*[@class='sell-USD']");
    private By nationalBank = By.xpath("//td[contains(text(),'Долар США')]//following::td[1]");


    @BeforeTest
    public void launch() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
       // System.setProperty("webdriver.chrome.driver", "D:/Documents/Automation/chromedriver.exe");
    }

    @Test
    public void currencyValues() {
        driver.get("https://www.privat24.ua/");
        String privateBankCurrency = driver.findElement(privateBank).getText();
        String[] privateBankDollarValue = privateBankCurrency.split("/");
        double privateBankDollarValueBuy = Double.valueOf(privateBankDollarValue[0]);
        double privateBankDollarValueSell = Double.valueOf(privateBankDollarValue[1]);
        System.out.println("Dollar purchase currency in PrivateBank: " + privateBankDollarValueBuy
                + "\nDollar selling currency in PrivateBank: " + privateBankDollarValueSell);


        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        double ukrsibDollarBuyValue = Double.valueOf(driver.findElement(ukrsibBankBuy).getText());
        double ukrsibDollarSellValue = Double.valueOf(driver.findElement(ukrsibBankSell).getText());
        System.out.println("\nDollar purchase currency in UkrsibBank: " + ukrsibDollarBuyValue
                + "\nDollar selling currency in UkrsibBank: " + ukrsibDollarSellValue);


        driver.get("https://www.universalbank.com.ua/");
        double universalDollarBuyValue = Double.valueOf(driver.findElement(universalBankBuy).getText());
        double universalDollarSellValue = Double.valueOf(driver.findElement(universalBankSell).getText());
        System.out.println("\nDollar purchase currency in UniversalBank: " + universalDollarBuyValue
                + "\nDollar selling currency in UniversalBank: " + universalDollarSellValue);


        driver.get("https://www.oschadbank.ua/ua");
        double oshadDollarBuyValue = Double.valueOf(driver.findElement(oshadBankBuy).getText());
        double oshadDollarSellValue = Double.valueOf(driver.findElement(oshadBankSell).getText());
        System.out.println("\nDollar purchase currency in OshadBank: " + oshadDollarBuyValue
                + "\nDollar selling currency in OshadBank: " + oshadDollarSellValue);


        driver.get("https://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        double nationalBankDollar = Double.valueOf(driver.findElement(nationalBank).getText());
        System.out.println("\nNational Bank exchange rate: " + nationalBankDollar/100);


        System.out.println("\nAverage currency of dollars purchase among all banks: "
                + ((privateBankDollarValueBuy+ukrsibDollarBuyValue+oshadDollarBuyValue+universalDollarBuyValue)/4));
        System.out.println("Average currency of dollars sale among all banks: "
                + ((privateBankDollarValueSell+ukrsibDollarSellValue+oshadDollarSellValue+universalDollarSellValue)/4));


        double[] listDollarsBuy = {privateBankDollarValueBuy,ukrsibDollarBuyValue,oshadDollarBuyValue, universalDollarBuyValue};
        Arrays.sort(listDollarsBuy);
        if (listDollarsBuy[0]== privateBankDollarValueBuy)
            System.out.println("\n\nThe minimal purchase dollar currency in Private Bank: " + listDollarsBuy[0]);
        if (listDollarsBuy[0]== ukrsibDollarBuyValue)
            System.out.println("\n\nThe minimal purchase dollar currency in Ukrsib Bank: " + listDollarsBuy[0]);
        if (listDollarsBuy[0]== oshadDollarBuyValue)
            System.out.println("\n\nThe minimal purchase dollar currency in Oshad Bank: " + listDollarsBuy[0]);
        if (listDollarsBuy[0]== universalDollarBuyValue)
            System.out.println("\n\nThe minimal purchase dollar currency in Universal Bank: " + listDollarsBuy[0]);

        if (listDollarsBuy[listDollarsBuy.length-1] == privateBankDollarValueBuy)
            System.out.println("The maximal purchase dollar currency in Private Bank: " + privateBankDollarValueBuy);
        if (listDollarsBuy[listDollarsBuy.length-1] == ukrsibDollarBuyValue)
            System.out.println("The maximal purchase dollar currency in Ukrsib Bank: " + ukrsibDollarBuyValue);
        if (listDollarsBuy[listDollarsBuy.length-1] == oshadDollarBuyValue)
            System.out.println("The maximal purchase dollar currency in Oshad Bank: " + oshadDollarBuyValue);
        if (listDollarsBuy[listDollarsBuy.length-1] == universalDollarBuyValue)
            System.out.println("The maximal purchase dollar currency in Universal Bank: " + universalDollarBuyValue);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    }
