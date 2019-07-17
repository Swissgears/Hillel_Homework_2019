import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class ArrayAndNumber {
    public static void main(String[] args) {

        System.out.println("Enter the number to search: ");
        Scanner scanner = new Scanner(System.in);
        int elementToSearch = scanner.nextInt();

        Random random = new Random();
        int[] randomNumbers = new int[10];
        int minNumber = 0;
        int maxNumber = 10;

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = minNumber + random.nextInt(maxNumber - minNumber + 1);
        }
        Arrays.sort(randomNumbers);
        System.out.println(binarySearch(randomNumbers, elementToSearch));
    }

    private static boolean binarySearch(int[] list, int key) {

        int firstIndex = 0;
        int lastIndex = list.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (list[middleIndex] == key) {
                return true;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (list[middleIndex] < key)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (list[middleIndex] > key)
                lastIndex = middleIndex - 1;
        }
        return false;
    }
}

        /*
        Написать метод. Входящие параметры: отсортированный массив и число.

        Метод должен вернуть true если это число есть в массиве, используя бинарный поиск.
        */