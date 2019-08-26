import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class StreamDemo {
    public static void main(String[] args) {

        Random random = new Random();
        ArrayList<Double> randomNumbers = new ArrayList<>();
        int minNumber = 0;
        int maxNumber = 20;

        for (int i = 0; i < 10; i++) {
            int pow = 2;
            randomNumbers.add(Math.pow(minNumber + random.nextInt(maxNumber - minNumber + 1), pow));
        }

        Optional<Double> sum = randomNumbers.stream().reduce((acc, x) -> acc + x);

        sum.ifPresent(System.out::println);
    }
}
/*
Создать список случайных чисел. Используя Stream Api подсчитать среднее арифиметическое квадратов этих чисел.
*/