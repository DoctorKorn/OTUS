import java.io.*;

public class NegativeValueException extends Exception {
    @Override
    public String getMessage() {
        return "Отрицательное значение недопустимо!";
    }
}
