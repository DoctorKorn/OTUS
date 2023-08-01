package Converter.UserMenu;

import Converter.Enum.*;
public interface UserMenu {

    void showMenu();

    Command getCommandWithRetry();

    Currency getCurrencyWithRetry();

    int getNumberWithRetry();

    void showResult(String result);
}