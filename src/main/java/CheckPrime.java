import java.util.ArrayList;
import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;
        ArrayList dividers = new ArrayList();
        boolean isPrimeNumber;

        while (true) {
            isPrimeNumber = false;
            dividers.clear();

            System.out.println("Enter the number to check: ");
            number = scanner.nextInt();

            if (number < 2) {
                System.out.println(number + " is not prime number");
                System.out.println();
                continue;
            } else {
                for (Integer i = 2; i <= number; i++) {
                    if (number % i == 0) {
                        dividers.add(i);
                    }
                }

                if (dividers.size() == 1) {
                    isPrimeNumber = true;
                }
            }

            if (isPrimeNumber) {
                System.out.println(number + " is prime number");
                System.out.println();
            } else {
                System.out.println(number + " is not prime number");
                System.out.println("It's dividers are:");
                for (int i = 0; i < dividers.size() - 1; i++) {
                    System.out.println(dividers.get(i));
                }
                System.out.println();
            }
        }
    }
}

/*
Написать метод который проверяет число простое или нет. Если нет вывести все его делители.
*/