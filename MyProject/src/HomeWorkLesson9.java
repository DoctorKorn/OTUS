import java.util.Scanner;

public class HomeWorkLesson9 {

    public static void main(String[] args) {
        ProcessTest();
    }
    public static void ProcessTest() {
        Question[] questions = new Question []{
                new Question(1,
                        "На какой реке стоит город Санкт-Петербург?",
                        new Answer[]{new Answer(1, "Енисей", false),
                                new Answer(2, "Волга", false),
                                new Answer(3, "Нева", true),
                                new Answer(4, "Лена", false)}),
                new Question(2,
                        "Виды какого города можно увидеть на российской купюре в 500 рублей?",
                        new Answer[]{new Answer(1, "Москва", false),
                                new Answer(2, "Красноярск", false),
                                new Answer(3, "Ярославль", false),
                                new Answer(4, "Архангельск", true)}),
                new Question(3,
                        "В это озеро нашей страны впадает множество рек, а вытекает только одна -Ангара",
                        new Answer[]{new Answer(1, "Байкал", true),
                                new Answer(2, "Селигер", false),
                                new Answer(3, "Ладожское", false),
                                new Answer(4, "Виктория", false)})
        };
        int correctCount = 0, wrongCount = 0;
        for (Question i : questions){
            //Проверяем ответ и выводим результат
            if (i.ask()){
                correctCount++;
                System.out.println("Ваш ответ верный!");
                System.out.println();
            } else {
                wrongCount++;
                System.out.println("Ваш ответ неверный!");
                System.out.println();
            };
        }
        //Выводим общий результат
        System.out.println("Ваш результат: правильно " + correctCount + ", неправильно " + wrongCount);
        if (correctCount > wrongCount) {
            System.out.println("Поздравляем! Вы прошли тест!");
        } else {
            System.out.println("К сожалению, тест не пройден! Попробуйте еще раз.");
        }
    }

}
