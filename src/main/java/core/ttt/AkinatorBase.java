package core.ttt;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AkinatorBase {

    static WebDriver driver;
    static By StartGame = By.xpath("//*[@class=\"btn-play\"]");
    static By Question = By.xpath("//*[@class='question-text']");
    static By Answer_Yes = By.xpath("//*[@id=\"a_yes\"]");
    static By Answer_No = By.xpath("//*[@id=\"a_no\"]");
    static By Answer_IDontKnow = By.xpath("//*[@id=\"a_dont_know\"]");
    static By Answer_Probably = By.xpath("//*[@id=\"a_probably\"]");
    static By Answer_ProbablyNot = By.xpath("//*[@id=\"a_probably_not\"]");
    static By Proposal_Title = By.xpath("//*[@class=\"proposal-title\"]");
    static By Proposal_SubTitle = By.xpath("//*[@class=\"proposal-subtitle\"]");

    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        //System.setProperty("webdriver.chrome.driver", "D:/Documents/Automation/chromedriver.exe");
    }

    static void yourAnswer(int answer) {
        switch (answer) {
            case 1:
                driver.findElement(Answer_Yes).click();
                break;
            case 2:
                driver.findElement(Answer_No).click();
                break;
            case 3:
                driver.findElement(Answer_IDontKnow).click();
                break;
            case 4:
                driver.findElement(Answer_Probably).click();
                break;
            case 5:
                driver.findElement(Answer_ProbablyNot).click();
                break;
        }
    }

    static boolean isElementDisplays(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }}
