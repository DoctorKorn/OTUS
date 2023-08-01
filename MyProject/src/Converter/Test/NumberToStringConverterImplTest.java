package Converter.Test;

import Converter.NumberConverter.NumberToStringConverterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class NumberToStringConverterImplTest {
    private final NumberToStringConverterImpl converter = new NumberToStringConverterImpl();

    @Test
    @DisplayName("Проверка преобразования числа в словесную форму")
    void convert() {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(0, "Ноль");
        testMap.put(32, "Тридцать два");
        testMap.put(705, "Семьсот пять");
        testMap.put(1108, "Одна тысяча сто восемь");
        testMap.put(10301, "Десять тысяч триста один");
        testMap.put(5677919, "Пять миллионов шестьсот семьдесят семь тысяч девятьсот девятнадцать");
        for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
            Integer number = entry.getKey();
            String expectedResult = entry.getValue();
            String actualResult = converter.convert(number);
            Assertions.assertEquals(expectedResult, actualResult);
        }
    }
}