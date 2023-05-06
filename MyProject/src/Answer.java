public class Answer {
    protected int number;
    private String answer;

    protected Boolean isCorrect;

    public Answer(int number, String answer, Boolean isCorrect) {
        this.number = number;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public void printAnswer(){
        System.out.println(number + ") " + answer);
    }
}
