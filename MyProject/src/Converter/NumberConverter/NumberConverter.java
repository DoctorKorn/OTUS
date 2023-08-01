package Converter.NumberConverter;

import Converter.CurrencyAppender.CurrencyAppender;
import Converter.CurrencyAppender.CurrencyAppenderFactory;
import Converter.Enum.Command;
import Converter.Enum.Currency;
import Converter.UserMenu.*;

public class NumberConverter {
    private final UserMenu userMenu;
    private final NumberToStringConverter numberToStringConverter;
    private final CurrencyAppenderFactory currencyAppenderFactory;

    public NumberConverter(UserMenu menu,
                           NumberToStringConverter converter,
                           CurrencyAppenderFactory currencyAppenderFactory) {
        this.userMenu = menu;
        this.numberToStringConverter = converter;
        this.currencyAppenderFactory = currencyAppenderFactory;
    }

    public void run() {
        while (true) {
            this.userMenu.showMenu();
            Command command = userMenu.getCommandWithRetry();
            int number;
            if (command.equals(Command.CONVERT)) {
                number = userMenu.getNumberWithRetry();
                Currency currency = userMenu.getCurrencyWithRetry();
                CurrencyAppender currencyAppender = currencyAppenderFactory.getCurrencyAppender(currency);
                String result = numberToStringConverter.convert(number);
                result += " " + currencyAppender.appendCurrency(number);
                this.userMenu.showResult(result);
            } else if (command.equals(Command.QUIT)) {
                return;
            }
        }
    }
}