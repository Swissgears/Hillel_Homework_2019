import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingLinesInFile {

    public static void main(String[] args) throws FileNotFoundException {

        int linesCounter = 0;
        int wordsCounter = 0;
        int charsCounter = 0;

        File file = new File("SomeText");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            linesCounter++;
            String line = scanner.nextLine().trim();
            String[] numberString = line.split(" ");
            wordsCounter = wordsCounter + numberString.length;

            char[] chars = line.toCharArray();
            charsCounter = charsCounter + chars.length;
        }

        System.out.println("Number of lines in a text file: " + linesCounter);
        System.out.println("Number of words in a text file: " + wordsCounter);
        System.out.println("Number of signs in text file: " + charsCounter);
        scanner.close();
    }
}

/*
Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов
 */