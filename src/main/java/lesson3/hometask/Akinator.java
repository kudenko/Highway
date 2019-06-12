package lesson3.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Akinator {
//    Это джин который задавая вам вопросы отгадает какого персонажа вы задумали.
//
//Суть в чем, вам нужно перенести данную "игру" в консоль
//Вы открываете сайт http://ru.akinator.com/ и начинаете играть
//Все вопросы вы выводите в консоль + варианты ответа которые предлагает Акинатор
//В консоли вы вводите цифру ответа, браузер соответсвенно будет делать нажатие выбранного ответа на сайте.
//
//
//Пример:
//в консоль выводит
//
//Вопрос: У вашего персонажа есть канал на YouTube?
//Варианты ответа:
//Да - 1
//Нет - 2
//Я не знаю - 32
//Возможно Частично - 4
//Скорее нет Не совсем - 5




    public static void main(String[] args) {
        WebDriver  driver = new ChromeDriver();
        driver.get("https://ru.akinator.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[@href='/game']")).click();
        boolean isContinue = true;
        while (isContinue) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(driver.findElements(By.xpath("//div[@class='bubble-propose bubble']")).size() != 0){
                isContinue = false;
                continue;
            }

            System.out.println("Вопрос: " + driver.findElement(By.xpath("//p[@class='question-text']")).getText());
            WebElement first = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[1]"));
            WebElement second = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[2]"));
            WebElement third = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[3]"));
            WebElement fourth = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[4]"));
            WebElement fifth = driver.findElement(By.xpath("(//a[@href='javascript:void(0);'])[5]"));

            System.out.println(first.getText() + " 1");
            System.out.println(second.getText() + " 2");
            System.out.println(third.getText() + " 3");
            System.out.println(fourth.getText() + " 4");
            System.out.println(fifth.getText() + " 5");


            boolean isCorrect = true;

            while (isCorrect) {
                System.out.println("Type numbers from 1 to 5");
                try {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println(" in try");
                    int a = Integer.parseInt(scanner.nextLine());
                    if(a > 5 || a <1){
                        System.out.println("Type numbers from 1 to 5");
                        isCorrect = true;
                    }else{
                        switch (a){
                            case 1: {
                                first.click();
                                isCorrect = false;
                                break;
                            }
                            case 2: {
                                second.click();
                                isCorrect = false;
                                break;
                            }
                            case 3: {
                                third.click();
                                isCorrect = false;
                                break;
                            }
                            case 4:{
                                fourth.click();
                                isCorrect = false;
                                break;
                            }
                            case 5: {
                                fifth.click();
                                isCorrect = false;
                                break;
                            }
                            default:{
                                System.out.println("DEFAULT");
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("You should write numbers from 1 to 5");
                    isCorrect = true;
                }
            }
        }

        WebElement yes = driver.findElement(By.xpath("//*[@id='a_propose_yes']"));
        WebElement no = driver.findElement(By.xpath("//*[@id='a_propose_no']"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Я думаю это " +  driver.findElement(By.xpath("//span[@class='proposal-title']")).getText() + "\n");
        System.out.println(driver.findElement(By.xpath("//span[@class='proposal-subtitle']")).getText());

        System.out.println("Pres 1 for yes and 2 for no");
        if(sc.nextInt() == 1){
            yes.click();
        }else {
            no.click();
        }



    }




}

