import java.io.IOException;
import java.util.Scanner;

public class HomeWorkLesson14 {

    public static void main(String args[]) {
        System.out.println("---------------------------------------");
        System.out.println("Проверка получения своего исключения");
        System.out.println("---------------------------------------");
        testOwnException();
        System.out.println("---------------------------------------");
        System.out.println("Проверка получения исключения ArrayIndexOutOfBoundsException");
        System.out.println("---------------------------------------");
        testOutOfBoundException();
        System.out.println("---------------------------------------");
        System.out.println("Проверка получения IO исключения и работы try with resources");
        System.out.println("---------------------------------------");
        System.out.println("Введите путь к существующему текстовому файлу .txt:");
        testExceptions();
        System.out.println("Введите путь к несуществующему файлу:");
        testExceptions();
    }

    public static void testOwnException() {
        try {
            ExceptionsTest.throwOwnExceptionExample(-1);
        } catch (NegativeValueException nv) {
            System.out.println(nv.getMessage());
        }
    }

    public static void testOutOfBoundException() {
        try {
            ExceptionsTest.throwOutOfBoundException(6);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
    public static void testExceptions() {
      Scanner scanner = new Scanner(System.in);
      try {
          //"C:\Users\79175\OTUS\MyProject\java.txt"
          String filePath = scanner.nextLine();
          if (filePath == "") {
              throw new IOException("Вы не ввели путь к файлу!");
          } else {
              ExceptionsTest.tryWithResourceExample(filePath);
          }
      } catch (IOException e) {
          System.out.println("Исключение IO: " + e.getMessage());
      }
    }
}