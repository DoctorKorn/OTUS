package Converter.UserMenu;

import Converter.Enum.*;
import Converter.Exception.*;
public class ConsoleUserMenu implements UserMenu {

    private final InputMenu inputMenu;
    private final OutputMenu outputMenu;

    public ConsoleUserMenu(InputMenu inputMenu, OutputMenu outputMenu) {
        this.inputMenu = inputMenu;
        this.outputMenu = outputMenu;
    }

    @Override
    public void showMenu() {
        showMessage("Выберите действие:");
        showMessage("C: Преобразовать число в словесную форму");
        showMessage("Q: Завершить работу");
    }

    private int getNumber() throws IncorrectNumberException {
        showMessage("Введите число:");
        int number;
        try {
            number = inputMenu.getNumber();
        } catch (Exception e) {
            throw new IncorrectNumberException("Некорректный формат числа!");
        }
        if (0 <= number && number < 1000000000) {
            return number;
        } else {
            throw new IncorrectNumberException("На текущий момент преобразование чисел реализовано в интервале от 0 до 1000000000");
        }
    }

    private Currency getCurrency() throws IncorrectCurrencyException {
        showMessage("Ввведите код валюты, например: RUR");
        try {
            return Currency.valueOf(inputMenu.getText());
        } catch (IllegalArgumentException e) {
            throw new IncorrectCurrencyException("На текущий момент реализовано перобразование чисел для валюты RUR");
        }
    }

    @Override
    public void showResult(String result) {
        showMessage(result);
    }

    private Command getCommand() throws IncorrectCommandException {
        try {
            return Command.fromInputText(inputMenu.getText().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IncorrectCommandException(e.getMessage());
        }
    }

    private void showMessage(String message) {
        outputMenu.showMessage(message);
    }

    private void showError(String error) {
        outputMenu.showError(error);
    }

    @Override
    public Command getCommandWithRetry() {
        try {
            return getCommand();
        } catch (IncorrectCommandException e) {
            showError(e.getMessage());
            return getCommandWithRetry();
        }
    }

    @Override
    public Currency getCurrencyWithRetry() {
        try {
            return getCurrency();
        } catch (IncorrectCurrencyException e) {
            showError(e.getMessage());
            return getCurrencyWithRetry();
        }
    }

    @Override
    public int getNumberWithRetry() {
        try {
            return getNumber();
        } catch (IncorrectNumberException e) {
            showError(e.getMessage());
            return getNumberWithRetry();
        }
    }
}