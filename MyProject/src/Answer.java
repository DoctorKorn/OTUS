public class Answer {
    private final int number;
    private final String answer;

    private final Boolean isCorrect;

    public Answer(int number, String answer, Boolean isCorrect) {
        this.number = number;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public void printAnswer(){
        System.out.println(number + ") " + answer);
    }

    public int getAnswerNum() {
        return number;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }
}
