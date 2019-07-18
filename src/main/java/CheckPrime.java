import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {

        System.out.println("Enter the number to check: ");
        Scanner scanner = new Scanner(System.in);
        int checkedNumber = scanner.nextInt();

        int i, m, flag = 0;

        m = checkedNumber / 2;

        if (checkedNumber == 0 || checkedNumber == 1) {
            System.out.println(checkedNumber + " is not prime number");

        } else {

            for (i = 2; i <= m; i++) {

                if (checkedNumber % i == 0) {

                    System.out.println(checkedNumber + " is not prime number");
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                System.out.println(checkedNumber + " is prime number");
            }
        }//end of else
    }
}






/*
Написать метод который проверяет число простое или нет. Если нет вывести все его делители.
*/