package core.ttt;

import java.util.Scanner;

public class AkinatorMain extends AkinatorBase {

    /**
     * http://ru.akinator.com/
     * Это джин который задавая вам вопросы отгадает какого персонажа вы задумали.
     *
     *      Суть в чем, вам нужно перенести данную "игру" в консоль
     *      Вы открываете сайт http://ru.akinator.com/ и начинаете играть
     *      Все вопросы вы выводите в консоль + варианты ответа которые предлагает Акинатор
     *      В консоли вы вводите цифру ответа, браузер соответсвенно будет делать нажатие выбранного ответа на сайте.
     */


    public static void main(String[] args) {

        setUp();

        driver.get("https://ru.akinator.com/");
        driver.findElement(StartGame).click();

        try {
            while (isElementDisplays(Question, 5) ) {
                System.out.println(driver.findElement(Question).getText());
                System.out.println("Выберите варианты ответа: \n"
                        + "1 - Да\n"
                        + "2 - Нет\n"
                        + "3 - Я не знаю\n"
                        + "4 - Возможно частично\n"
                        + "5 - Скорее Нет/Совсем Нет" );
                Scanner scanner = new Scanner(System.in);
                int answer = scanner.nextInt();
                yourAnswer(answer);
                //wait when page loaded
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(driver.findElement(Proposal_Title).getText() +"\n"
                + driver.findElement(Proposal_SubTitle).getText());
        driver.quit();
    }
}