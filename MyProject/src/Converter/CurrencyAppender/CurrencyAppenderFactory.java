package Converter.CurrencyAppender;

import Converter.Enum.Currency;
import java.util.HashMap;
import java.util.Map;

public class CurrencyAppenderFactory {
    private final static Map<Currency, CurrencyAppender> currencyAppenderMap = new HashMap<>();

    public CurrencyAppenderFactory() {
        for (Currency cur : Currency.values()) {
            currencyAppenderMap.put(cur, createCurrencyAppender(cur));
        }
    }

    public static CurrencyAppender createCurrencyAppender(Currency currency) {
        if (currency.equals(Currency.RUR)) {
            return new CurrencyAppenderRoubles();
        } else {
            throw new IllegalArgumentException("Некорректный код валюты");
        }
    }

    public CurrencyAppender getCurrencyAppender(Currency currency) {
        return currencyAppenderMap.get(currency);
    }
}