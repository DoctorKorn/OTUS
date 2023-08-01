package Converter.Test;

import Converter.Enum.*;
import Converter.UserMenu.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ConsoleUserMenuTest {
    @Test
    @DisplayName("Проверка передачи разного рода команд из консоли")
    void getActionWithRetry() {
        List<String> expectedErrors = new ArrayList<>(Arrays.asList(
                "Неизвестная команда: CONVERT",
                "Неизвестная команда: 000",
                "Неизвестная команда: QUIT"));
        List<String> actualErrors = new ArrayList<>();
        InputMenu inputMenu = new ConsoleInputMenu(new ByteArrayInputStream(("""
                CONVERT
                C
                000
                Quit
                Q""").getBytes()));
        class ConsoleOutputMenuTest extends ConsoleOutputMenu {
            @Override
            public void showError(String error) {
                super.showError(error);
                actualErrors.add(error);
            }
        }
        ConsoleUserMenu consoleUserMenu = new ConsoleUserMenu(inputMenu, new ConsoleOutputMenuTest());
        Assertions.assertEquals(consoleUserMenu.getCommandWithRetry(), Command.CONVERT);
        Assertions.assertEquals(consoleUserMenu.getCommandWithRetry(), Command.QUIT);
        Assertions.assertEquals(expectedErrors, actualErrors);
    }

    @Test
    @DisplayName("Проверка передачи разного рода валют из консоли")
    void getCurrencyWithRetry() {
        List<String> expectedErrors = new ArrayList<>(Arrays.asList(
                "На текущий момент реализовано перобразование чисел для валюты RUR",
                "На текущий момент реализовано перобразование чисел для валюты RUR",
                "На текущий момент реализовано перобразование чисел для валюты RUR"));
        List<String> actualErrors = new ArrayList<>();
        InputMenu inputMenu = new ConsoleInputMenu(new ByteArrayInputStream(("""
                currency
                
                рубли
                RUR""").getBytes()));
        class ConsoleOutputMenuTest extends ConsoleOutputMenu {
            @Override
            public void showError(String error) {
                super.showError(error);
                actualErrors.add(error);
            }
        }
        ConsoleUserMenu consoleUserMenu = new ConsoleUserMenu(inputMenu, new ConsoleOutputMenuTest());
        Assertions.assertEquals(consoleUserMenu.getCurrencyWithRetry(), Currency.RUR);
        Assertions.assertEquals(expectedErrors, actualErrors);
    }

    @Test
    @DisplayName("Проверка передачи разного рода чисел из консоли")
    void getNumberWithRetry() {
        List<String> expectedErrors = new ArrayList<>(Arrays.asList(
                "На текущий момент преобразование чисел реализовано в интервале от 0 до 1000000000",
                "Некорректный формат числа!",
                "Некорректный формат числа!"));
        List<String> actualErrors = new ArrayList<>();
        InputMenu inputMenu = new ConsoleInputMenu(new ByteArrayInputStream(("""
                -200
                387
                3000000000
                21
                0
                число
                575003""").getBytes()));
        class ConsoleOutputMenuTest extends ConsoleOutputMenu {
            @Override
            public void showError(String error) {
                super.showError(error);
                actualErrors.add(error);
            }
        }
        ConsoleUserMenu consoleUserMenu = new ConsoleUserMenu(inputMenu, new ConsoleOutputMenuTest());
        Assertions.assertEquals(consoleUserMenu.getNumberWithRetry(), 387);
        Assertions.assertEquals(consoleUserMenu.getNumberWithRetry(), 21);
        Assertions.assertEquals(consoleUserMenu.getNumberWithRetry(), 0);
        Assertions.assertEquals(consoleUserMenu.getNumberWithRetry(), 575003);
        Assertions.assertEquals(expectedErrors, actualErrors);
    }
}
