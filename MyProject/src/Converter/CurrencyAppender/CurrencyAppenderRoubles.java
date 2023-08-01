package Converter.CurrencyAppender;

public class CurrencyAppenderRoubles implements CurrencyAppender {
    @Override
    public String appendCurrency(int number) {
        if (number % 100 > 4 && number % 100 < 21) {
            return "рублей";
        } else if (number % 10 == 1) {
            return "рубль";
        } else if (number % 10 == 2 || number % 10 == 3 || number % 10 == 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}