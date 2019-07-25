import java.util.Arrays;
import java.util.Random;

public class SortingTwoDimensionalArray {

    public static void main(String[] args) {

        Random random = new Random();
        int minNumber = 0;
        int maxNumber = 100;

        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(maxNumber - minNumber + 1); // наполнение двумерного массива случайными числами
            }
        }

        int[] flatArray = new int[5 * 5];

        int counter = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                flatArray[counter++] = array[row][col]; // преобразование двумерного массива в одномерный
            }
        }

        Arrays.sort(flatArray);

        counter = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                array[row][col] = flatArray[counter++]; // преобразование одномернщго отсортированного массива в двумерный
            }
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(array[row][col] + " ~ "); // вывод в консоль
            }
            System.out.println();
        }
    }
}



/*
 Создать 2мерный массив (матрица) M*N и заполнить его случайными числами. Отсортировать числа по возрастанию, чтобы с левом верхнем углу было самое маленькое число, справа от него следующее по значению, итд, в правом нижнем углу самое большое.
 */