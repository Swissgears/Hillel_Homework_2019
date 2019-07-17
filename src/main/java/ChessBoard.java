import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessBoard {

    static String inputString;

    public static void main(String[] args) {

        System.out.println("Point the way: ");

        int lineNumber = 0;
        int columnNumber = 0;

        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine().
                trim().
                toUpperCase();

        char[] line = inputString.toCharArray();

        if (inputName()) {
            char route = ' ';

            for (int i = 0; i < line.length; i++) {
                route = line[i];

                if (route == 'U') {
                    lineNumber = lineNumber + 1;
                } else if (route == 'D') {
                    lineNumber = lineNumber - 1;
                } else if (route == 'L') {
                    columnNumber = columnNumber - 1;
                } else if (route == 'R') {
                    columnNumber = columnNumber + 1;
                }
            }
            System.out.println(location(lineNumber, columnNumber));
        } else System.out.println("Wrong way");
    }

    private static boolean inputName() {

        Pattern p = Pattern.compile("[UDRL]+");
        Matcher m = p.matcher(inputString);
        return m.matches();
    }

    private static boolean location(int line, int column) {

        return (line == 0 && column == 0);
    }
}

    /*
    Есть поле из клеток по средине которого находится робот. Робот умеет выполнять 4 команды: двигаться на 1 клетку в сторону: R (right), L (left), U (up), and D (down).

    Задана строка из движений робота например "UUDLDR". Написать метод который вернет true если робот вернется в ту же клетку с которой начал.
     */
