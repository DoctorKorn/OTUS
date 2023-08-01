package Converter.Enum;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    CONVERT("C"),
    QUIT("Q");
    private static final Map<String, Command> commandMap = new HashMap<>();

    static {
        for (Command command : Command.values()) {
            commandMap.put(command.value, command);
        }
    }

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command fromInputText(String text) {
        Command command = commandMap.get(text.toUpperCase());
        if (command == null) {
            if (text.length() == 0) {
                throw new IllegalArgumentException("Вы не ввели команду!");
            } else {
                throw new IllegalArgumentException("Неизвестная команда: " + text);
            }
        }

        return command;
    }
}