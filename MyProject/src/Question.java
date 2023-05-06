public class Question {
    private int number;
    private String question;
    private final Answer [] answers;

    public Question(int number, String question, Answer[] answers) {
        this.number = number;
        this.question = question;
        this.answers = answers;
    }

    public void printQuestion(){
        System.out.println(number + ". " + question);
        for (Answer i : answers){
            i.printAnswer();
        }
    }

    public boolean CheckAnswer(int answerNumber){
        for (Answer i : answers){
            if (i.number == answerNumber){
                return i.isCorrect;
            };
        }
        return false;
    }
}
