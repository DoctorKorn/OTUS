import java.util.Scanner;

public class HomeWorkLesson6 {
    public static void main(String[] args) {
        int correctCount = 0, wrongCount = 0;

        String[] questions = {"На какой реке стоит город Санкт-Петербург?",
                              "Виды какого города можно увидеть на российской купюре в 500 рублей?",
                              "В это озеро нашей страны впадает множество рек, а вытекает только одна -Ангара"
        };

        // Массив вариантов ответов
        String[][] answerOptions = new String[][]{{"Енисей", "Волга", "Нева", "Лена"},
            {"Москва", "Красноярск", "Ярославль", "Архангельск"},
                        {"Байкал", "Селигер", "Ладожское", "Виктория"}
        };

        // Массив правильных ответов
        String[] correctAnswers = {"Нева", "Архангельск", "Байкал"};

        Scanner scanner = new Scanner(System.in);
        //Цикл по всем вопросам
        for (int i = 0; i < questions.length; i++) {
            //Вывод вопроса на экран
            System.out.println(questions[i]);
            //Вывод вариантов ответов на экран
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println(answerOptions[i][j].toString());
            }
            System.out.print("Ваш ответ: ");
            //Считываем с консоли ответ пользователя
            String answer = scanner.nextLine();
            //Проверяем ответ и выводим результат
            if (answer.equals(correctAnswers[i])){
                correctCount++;
                System.out.println("Ваш ответ верный!");
            } else {
                wrongCount++;
                System.out.println("Ваш ответ неверный!");
            };
            // а также увеличиваем счетчики правильных и неправильных ответов
            System.out.println();
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
