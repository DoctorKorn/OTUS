public class Answer {
    private final int number;
    private final String answer;

    private final Boolean isCorrect;

    public Answer(int number, String answer, Boolean isCorrect) {
        this.number = number;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getAnswer(){ return this.number + ") " + this.answer; }

    public boolean getCorrect() {
        return this.isCorrect;
    }

    public int getNumber() { return number; }
}
