package Converter.UserMenu;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInputMenu implements InputMenu {
    private final Scanner scanner;

    public ConsoleInputMenu(InputStream in) {
        this.scanner = new Scanner(in);
    }

    @Override
    public String getText() {
        return scanner.nextLine();
    }

    @Override
    public Integer getNumber() {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}