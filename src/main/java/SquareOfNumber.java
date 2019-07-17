import java.util.Arrays;
import java.util.Random;
import java.lang.Math;


public class SquareOfNumber {
    public static void main(String[] args) {

        Random random = new Random();
        double[] randomNumbers = new double[10];
        int minNumber = -10;
        int maxNumber = 10;

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = minNumber + random.nextInt(maxNumber - minNumber + 1);
            randomNumbers[i] = Math.pow(randomNumbers[i], 2);
        }
        System.out.println("Input " + Arrays.toString(randomNumbers));

        System.out.print("Output " + Arrays.toString(selectedSort(randomNumbers)));
    }

    private static double[] selectedSort(double[] list) {

        for (int i = 0; i < list.length; i++) {   // Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным

            double min = list[i];
            int min_i = i;
            for (int j = i + 1; j < list.length; j++) {  // В оставшейся части подмножества ищем элемент, который меньше предположенного минимума

                if (list[j] < min) {  // Если находим, запоминаем его индекс
                    min = list[j];
                    min_i = j;
                }
            }
            if (i != min_i) {  // Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами

                double tmp = list[i];
                list[i] = list[min_i];
                list[min_i] = tmp;
            }

        }
        return list;
    }
}


//        2. Написать метод.
//
//        Входящий параметр: отсортированный массив типа int который содержит отрицательные и положительные значения.
//
//        Вернуть отсортированный массив который состоит из квадратов значений.
//
//        Не использовать при этом стандартный метод sort.
