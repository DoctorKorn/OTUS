package Converter.Test;

 import Converter.CurrencyAppender.CurrencyAppenderFactory;
 import Converter.Enum.*;
 import Converter.NumberConverter.NumberConverter;
 import Converter.NumberConverter.NumberToStringConverterImpl;
 import Converter.UserMenu.*;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.Assertions;

 import java.util.HashMap;
 import java.util.Map;


class NumberConverterTest {

    @Test
    @DisplayName("Проверка работы приложения")
    void run() {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(0, "Ноль рублей");
        testMap.put(32, "Тридцать два рубля");
        testMap.put(705, "Семьсот пять рублей");
        testMap.put(1108, "Одна тысяча сто восемь рублей");
        testMap.put(10301, "Десять тысяч триста один рубль");
        testMap.put(5677919, "Пять миллионов шестьсот семьдесят семь тысяч девятьсот девятнадцать рублей");
        for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
            Integer number = entry.getKey();
            String expectedResult = entry.getValue();
            class ConsoleUserMenuTest extends ConsoleUserMenu {
                public String actualResult;
                boolean exit = false;

                public ConsoleUserMenuTest(InputMenu inputMenu, OutputMenu outputMenu) {
                    super(inputMenu, outputMenu);
                }

                @Override
                public Command getCommandWithRetry() {
                    if (exit) {
                        exit = false;
                        System.out.println("Q");
                        return Command.QUIT;
                    } else {
                        exit = true;
                        System.out.println("C");
                        return Command.fromInputText("C");
                    }
                }

                @Override
                public int getNumberWithRetry() {
                    System.out.println(number);
                    return number;
                }

                @Override
                public Currency getCurrencyWithRetry() {
                    System.out.println("RUR");
                    return Currency.valueOf("RUR");
                }

                @Override
                public void showResult(String result) {
                    super.showResult(result);
                    actualResult = result;
                }
            }
            ConsoleUserMenuTest userMenu = new ConsoleUserMenuTest(new ConsoleInputMenu(System.in), new ConsoleOutputMenu());
            NumberConverter converter = new NumberConverter(userMenu, new NumberToStringConverterImpl(), new CurrencyAppenderFactory());
            converter.run();
            Assertions.assertEquals(expectedResult, userMenu.actualResult);
        }
    }
}