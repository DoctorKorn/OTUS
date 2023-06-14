import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestGame {
    @DisplayName("Игра в кости: равенство результатов")
    @Test
    public void testPlayGameDiceValueEqual(){
        Dice dice = new TestDiceImpl(0);
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        //найденный в интернете механизм проверки методов void с System.out.println
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        game.playGame(new Player("Вася"), new Player("Игорь"));
        try{
            Assertions.assertEquals("Ничья", outputStreamCaptor.toString().trim());
        }catch(AssertionError e){
            System.err.println("Игра в кости: равенство результатов - failed");
            throw e;
        }
        System.setOut(standardOut);
        System.out.println("Игра в кости: равенство результатов - passed");
    }
    @DisplayName("Игра в кости: проверка на пустое имя игрока 1")
    @Test
    public void testPlayGameNullNamePlayer1(){
        Dice dice = new TestDiceImpl(1);
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        //найденный в интернете механизм проверки методов void с System.out.println
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        game.playGame(new Player(""), new Player("Игорь"));
        try{
            Assertions.assertEquals("Победитель: Вася", outputStreamCaptor.toString().trim());
        }catch(AssertionError e){
            System.err.println("Игра в кости: проверка на пустое имя игрока 1 - failed");
            throw e;
        }
        System.setOut(standardOut);
        System.out.println("Игра в кости: проверка на пустое имя игрока 1 - passed");
    }
    @DisplayName("Игра в кости: проверка на пустое имя игрока 2")
    @Test
    public void testPlayGameNullNamePlayer2(){
        Dice dice = new TestDiceImpl(2);
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        //найденный в интернете механизм проверки методов void с System.out.println
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        game.playGame(new Player("Вася"), new Player(""));
        try{
            Assertions.assertEquals("Победитель: Игорь", outputStreamCaptor.toString().trim());
        }catch(AssertionError e){
            System.err.println("Игра в кости: проверка на пустое имя игрока 2 - failed");
            throw e;
        }
        System.setOut(standardOut);
        System.out.println("Игра в кости: проверка на пустое имя игрока 2 - passed");
    }
    @DisplayName("Игра в кости: проверка на выигрыш игрока 1")
    @Test
    public void testPlayGameWinnerPlayer1(){
        Dice dice = new TestDiceImpl(1);
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        //найденный в интернете механизм проверки методов void с System.out.println
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        game.playGame(new Player("Вася"), new Player("Игорь"));
        try{
            Assertions.assertEquals("Победитель: Вася", outputStreamCaptor.toString().trim());
        }catch(AssertionError e){
            System.err.println("Игра в кости: проверка на выигрыш игрока 1 - failed");
            throw e;
        }
        System.setOut(standardOut);
        System.out.println("Игра в кости: проверка на выигрыш игрока 1 - passed");
    }
    @DisplayName("Игра в кости: проверка на выигрыш игрока 2")
    @Test
    public void testPlayGameWinnerPlayer2(){
        Dice dice = new TestDiceImpl(2);
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        //найденный в интернете механизм проверки методов void с System.out.println
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        game.playGame(new Player("Вася"), new Player("Игорь"));
        try{
            Assertions.assertEquals("Победитель: Игорь", outputStreamCaptor.toString().trim());
        }catch(AssertionError e){
            System.err.println("Игра в кости: проверка на выигрыш игрока 2 - failed");
            throw e;
        }
        System.setOut(standardOut);
        System.out.println("Игра в кости: проверка на выигрыш игрока 2 - passed");
    }
    private class TestDiceImpl implements Dice{
        final int mode;
        int counter = 0;

        public TestDiceImpl(int mode){
            this.mode = mode;
        }
        @Override
        public int roll() {
            if (this.mode == 0) {
                return 1;
            } else if (this.mode == 1){
                if (this.counter == 0){
                    this.counter++;
                    return 6;
                } else {
                    return 1;
                }
            } else {
                if (this.counter == 0){
                    this.counter++;
                    return 1;
                } else {
                    return 6;
                }
            }
        }
    }

}
