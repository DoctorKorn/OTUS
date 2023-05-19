import java.util.Scanner;

public class Question {
    private final int number;
    private final String question;
    private final Answer [] answers;

    public Question(int number, String question, Answer[] answers) {
        this.number = number;
        this.question = question;
        this.answers = answers;
    }

    public boolean ask() {
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        // Вывод вопроса на экран
        System.out.print(this.number + ". " + this.question);
        System.out.println();
        //Вывод вариантов ответа на экран
        for (Answer i : answers){
            System.out.print(i.getAnswer());
            System.out.println();
        }
        System.out.println();
        System.out.print("Ваш ответ: ");
        //Считываем с консоли ответ пользователя
        int answer = scanner.nextInt();
        //Проверяем правильность ответа
        for (Answer i : answers){
            if (i.getNumber() == answer){
                return i.getCorrect();
            };
        }
        return false;
    }
}
