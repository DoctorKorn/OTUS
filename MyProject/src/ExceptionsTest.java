import java.io.*;

public class ExceptionsTest {
    public static void tryWithResourceExample(String filePath) throws IOException {
        System.out.println("Попытка прочесть файл " + filePath);
        try (MyBufferedReader reader = new MyBufferedReader(new FileReader(filePath));) {
            String firstLine = reader.readLine();
            System.out.println(firstLine);
        }
        System.out.println("Окончание чтения файла " + filePath);
    }

    public static void throwOwnExceptionExample(int a) throws NegativeValueException {
        if (a < 0) {
            throw new NegativeValueException();
        }
    }

    public static void throwOutOfBoundException(int item) {
        int[] intArray = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < item; i++) {
            System.out.println("Элемент массива " + i + " равен: " + intArray[i]);
        }
    }
}
