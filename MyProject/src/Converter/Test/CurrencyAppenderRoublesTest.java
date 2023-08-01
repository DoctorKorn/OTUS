package Converter.Test;

import Converter.CurrencyAppender.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CurrencyAppenderRoublesTest {

    private final CurrencyAppenderRoubles currencyAppender = new CurrencyAppenderRoubles();

    @Test
    @DisplayName("Проверка метода appendCurrency")
    void appendCurrency() {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(0, "рублей");
        testMap.put(101, "рубль");
        testMap.put(32, "рубля");
        testMap.put(43, "рубля");
        testMap.put(74, "рубля");
        testMap.put(87, "рублей");
        testMap.put(1000, "рублей");
        for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
            Integer number = entry.getKey();
            String expectedResult = entry.getValue();
            Assertions.assertEquals(expectedResult, currencyAppender.appendCurrency(number));
            }
        }
}