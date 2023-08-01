package Converter.Test;

import Converter.UserMenu.ConsoleInputMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;

class ConsoleInputMenuTest {

    @Test
    @DisplayName("Проверка метода getNumber с передачей на вход корректного числа")
    void getNumberCorrect() {
        ConsoleInputMenu consoleInputMenu = new ConsoleInputMenu(new ByteArrayInputStream("756003".getBytes()));
        Assertions.assertEquals(consoleInputMenu.getNumber(), 756003);
    }
    @Test
    @DisplayName("Проверка метода getNumber с передачей на вход текста")
    void getNumberWrongText() {
        ConsoleInputMenu consoleInputMenu = new ConsoleInputMenu(new ByteArrayInputStream("абракадабра".getBytes()));
        Assertions.assertThrows(NumberFormatException.class, consoleInputMenu::getNumber);
    }
    @Test
    @DisplayName("Проверка метода getNumber с передачей на вход прочие символы")
    void getNumberWrongSymbol() {
        ConsoleInputMenu consoleInputMenu = new ConsoleInputMenu(new ByteArrayInputStream("?./*_".getBytes()));
        Assertions.assertThrows(NumberFormatException.class, consoleInputMenu::getNumber);
    }
}