import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class HomeWorkLesson12 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListIntUnsorted = initArrayListInt();
        System.out.println("Неотсортированный массив: " + arrayListIntUnsorted);
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayListIntSorted = selectiveSortArray(arrayListIntUnsorted);
        long endTime = System.currentTimeMillis();
        System.out.println("Отсортированный массив: " + arrayListIntUnsorted);
        System.out.println("Время сортировки: " + (endTime - startTime) + " миллисекунд!");
    }

    public static ArrayList<Integer> initArrayListInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int length = scanner.nextInt();
        ArrayList<Integer> arrayInt = new ArrayList();
        //System.out.println("Введите элементы массива:");
        for (int i = 0; i < length; i++) {
            //arrayInt.add(scanner.nextInt());
            Random randomInt = new Random();
            int x = randomInt.nextInt(1000) + 1;
            arrayInt.add(x);
        }
        return arrayInt;
    }
    // сортировка выборкой
    public static ArrayList<Integer> selectiveSortArray (ArrayList<Integer> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            int minValue = arrayList.get(i);
            int minIndex = i;
            for (int j = i+1; j < arrayList.size(); j++) {
                if (arrayList.get(j) < minValue) {
                    minValue = arrayList.get(j);
                    minIndex = j;
                }
            }
            int replaceValue = arrayList.get(i);
            arrayList.set(i, minValue);
            arrayList.set(minIndex, replaceValue);
        }
        return arrayList;
    }
}
