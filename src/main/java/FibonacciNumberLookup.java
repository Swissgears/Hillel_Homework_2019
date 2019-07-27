import java.util.Scanner;

public class FibonacciNumberLookup {

    public static void main(String[] args) {

        long searchIndex = inputNumber();
        System.out.println("Fibonacci number index " + searchIndex + " ==> " + fibonacciSearch(searchIndex) + "\n");
        System.out.print("Fibonacci number series before index " + searchIndex + " ==> ");
        for (long i = 1; i <= searchIndex; i++) {
            System.out.print(fibonacciSearch(i) + " ");
        }
    }

    private static long inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Fibonacci number index: ");
        return scanner.nextInt();
    }

    private static long fibonacciSearch(long number) {
        long result;

        if (number == 0) {
            return 0;

        } else if (number == 1) {
            return 1;

        } else {
            result = fibonacciSearch(number - 1) + fibonacciSearch(number - 2);
            return result;

        }
    }
}
/*

Число Фибоначи. Написать метод который возвращает N-ное число фибоначи, по правилу:

F(0) = 0, F(1) = 1

F(N) = F(N - 1) + F(N - 2)

 */

