package Converter.NumberConverter;

import java.util.ArrayList;
import java.util.Collections;

public class NumberToStringConverterImpl implements NumberToStringConverter {
    private static final String[] UNITS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] TEENS = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[][] RANGES = {
            {"тысяча", "тысячи", "тысяч"},
            {"миллион", "миллиона", "миллионов"},
            {"миллиард","миллиарда","миллиардов"},
            {"триллион","триллиона","триллионов"}
    };

    @Override
    public String convert(Integer number) {
        if (number == 0) {
            return "Ноль";
        }
        ArrayList triples = new ArrayList();
        // разбиение целой части числа на составляющие кратные 1000, начиная с конца
        while (number > 0) {
            int triple = number / 1000;
            triples.add(number-(triple*1000));
            number = triple;
        }
        Collections.reverse(triples); // разворот массива полученных составляющих
        StringBuilder result = new StringBuilder();
        int arraySize = triples.size();
        // формирование слвесной формы переданного числа
        for (int i = 0; i < arraySize; i++ ) {
            int level = arraySize - i - 2;
            int value = Integer.valueOf(triples.get(i).toString());
            int hundreds = value / 100;
            int units = value % 10;
            int tens = (value % 100) / 10;
            if (hundreds > 0) {
                result.append(HUNDREDS[hundreds]).append(" ");
            }
            if (tens == 1 && units > 0) {
                // от 11 до 19
                result.append(TEENS[units]).append(" ");
            } else {
                // десятки от 10 до 90
                if (tens > 0) {
                    result.append(TENS[tens]).append(" ");
                }
                // определяем правильное наименование одной и двух тысяч, иначе согласно логике
                if ((units == 1 || units == 2) && level == 0) {
                    result.append(units == 1 ? "одна" : "две").append(" ");
                } else if (units > 0) {
                    // от 1 до 9
                    result.append(UNITS[units]).append(" ");
                }
            }
            // определение наименования размерности начиная с тысяч
            if (level >= 0) {
                if (tens == 1) {
                    result.append(RANGES[level][2]).append(" ");
                } else if (units == 1) {
                    result.append(RANGES[level][0]).append(" ");
                } else if (units > 0 && units < 5) {
                    result.append(RANGES[level][1]).append(" ");
                } else {
                    result.append(RANGES[level][2]).append(" ");
                }
            }
        }
        return result.substring(0, 1).toUpperCase() + result.substring(1).trim();
    }
}