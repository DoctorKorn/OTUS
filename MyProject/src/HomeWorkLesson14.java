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
        try {
            testOutOfBoundException();
        } catch(Exception e) {
            System.out.println("Печать стэка в main");
            e.printStackTrace(System.out);
        }
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
        } catch (NegativeValueException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testOutOfBoundException1() throws ArrayIndexOutOfBoundsException {
            try {
                ExceptionsTest.throwOutOfBoundException(6);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Печать стэка в testOutOfBoundException1");
                e.printStackTrace(System.out);
                throw e;
            }
    }
    public static void testOutOfBoundException() throws Exception {
        try {
            testOutOfBoundException1();
        } catch (Exception e) {
            System.out.println("Печать стэка в testOutOfBoundException");
            e.printStackTrace(System.out);
            throw new Exception("Что-то случилось в testOutOfBoundException1");
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