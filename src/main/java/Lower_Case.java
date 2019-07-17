
import java.io.*;

public class Lower_Case {

    public static void main(String args[]) throws IOException {

        System.out.println("Enter any line ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        System.out.println("Lower Case  without using toLowerCase() :  " + lCase(inputLine));

    }

    private static String lCase(String inputLine) {
        StringBuilder inputLineT = new StringBuilder(inputLine);

        for (int i = 0; i < inputLineT.length(); i++) {
            if (inputLineT.charAt(i) >= 65 && inputLineT.charAt(i) <= 91) {
                inputLineT.setCharAt(i, (char) (inputLineT.charAt(i) + 32));
            }
        }
        return inputLineT.toString();
    }
}


//   Дана строк состоящая из любых символов. Не используя стандартный метод String.toLowerCase() перевести все большие латинские буквы в маленькие.