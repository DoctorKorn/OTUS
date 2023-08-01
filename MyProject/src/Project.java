import Converter.CurrencyAppender.CurrencyAppenderFactory;
import Converter.NumberConverter.NumberConverter;
import Converter.NumberConverter.NumberToStringConverter;
import Converter.NumberConverter.NumberToStringConverterImpl;
import Converter.UserMenu.ConsoleInputMenu;
import Converter.UserMenu.ConsoleOutputMenu;
import Converter.UserMenu.ConsoleUserMenu;
import Converter.UserMenu.UserMenu;

public class Project {
    public static void main(String[] args) {
        NumberToStringConverter numberToStringConverter = new NumberToStringConverterImpl();
        UserMenu userMenu = new ConsoleUserMenu(new ConsoleInputMenu(System.in), new ConsoleOutputMenu());
        CurrencyAppenderFactory currencyAppenderFactory = new CurrencyAppenderFactory();
        NumberConverter numberConverter = new NumberConverter(userMenu, numberToStringConverter, currencyAppenderFactory);
        numberConverter.run();
    }
}