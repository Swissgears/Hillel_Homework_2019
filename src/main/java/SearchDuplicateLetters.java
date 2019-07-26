
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchDuplicateLetters {
    public static void main(String[] args) {

        System.out.println("Enter string that contains only latin alphabet symbols!");
        System.out.println("Enter the first line and click 'ENTER':");
        String userStringFirst = getValidInputString();
        System.out.println("Enter the second line and click 'ENTER':");
        String userStringSecond = getValidInputString();
        System.out.println(calculateCharacters(userStringFirst, userStringSecond));

    }

    public static String getValidInputString() {
        String result = "";


        Scanner console = new Scanner(System.in);
        Pattern pat = Pattern.compile("[a-zA-Z\\s']+");

        while (true) {
            result = console.nextLine();
            Matcher m = pat.matcher(result);
            if (m.matches()) {
                break;
            } else {
                System.out.println("Invalid string, try again...");
            }
        }
        return result;
    }

    public static int calculateCharacters(String first, String second) {

        if (first.length() != second.length()) { // вернуть -1, если строки разной длины
            return -1;
        }

        int mismatchCounter = 0;
        String result = first.trim() + second.trim(); // объединить строки и поместить в массив

        char[] chars = result.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) { // берет по очереди символ из первой половины массива и сверяет с символами из второй половины

            for (int j = chars.length / 2; j < chars.length; j++) {

                if (chars[i] == chars[j]) { // совпадающие символы заменить ' '
                    chars[i] = ' ';
                    chars[j] = ' ';
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != ' ') {
                mismatchCounter++;
            }
        }
        return mismatchCounter / 2;
    }
}
/*
Написать метод который принимает 2 строки - a, b. Метод должне вернуть количество символов которые у них различаются. Если строки разной длины то вернуть -1.

Примеры:

a="asdf", b="qwerty" => -1

a="abb", b="bba" => 0

a="abc", b="dca" => 1

a="aaa", b="fga" => 2

a="abc", b="dfg" => 3
 */
