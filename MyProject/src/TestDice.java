import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class TestDice {
    @DisplayName("Игра в кости: Проверка значений вне допустимого интервала")
    @Test
    public void testDiceImplRollWrongInterval(){
        ArrayList<Integer> array = initArray();
        //boolean expected = true;
        Dice actual = new IncorrectValueDiceImpl();
        int actualValue = actual.roll();
        //Assertions.assertEquals(expected, array.contains(actualValue));
        try{
            Assertions.assertTrue(array.contains(actualValue));
            System.out.println("Игра в кости: Проверка значений вне допустимого интервала - passed");
        }catch(AssertionError e){
            System.err.println("Игра в кости: Проверка значений вне допустимого интервала - failed");
            throw e;
        }
    }
    @DisplayName("Игра в кости: Проверка значений внутри допустимого интервала")
    @Test
    public void testDiceImplRollCorrectInterval(){
        ArrayList<Integer> array = initArray();
        //boolean expected = true;
        Dice actual = new CorrectValueDiceImpl();
        int actualValue = actual.roll();
        //Assertions.assertEquals(expected, array.contains(actualValue));
        try{
            Assertions.assertTrue(array.contains(actualValue));
            System.out.println("Игра в кости: Проверка значений внутри допустимого интервала - passed");
        }catch(AssertionError e){
            System.err.println("Игра в кости: Проверка значений внутри допустимого интервала - failed");
            throw e;
        }
    }
    private ArrayList<Integer> initArray(){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        return array;
    }
    private class IncorrectValueDiceImpl implements Dice{
        @Override
        public int roll() {
            return new Random().nextInt(6) + 10;
        }
    }
    private class CorrectValueDiceImpl implements Dice{
        @Override
        public int roll() {
            return new Random().nextInt(6) + 1;
        }
    }
}
