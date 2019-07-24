import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateStringConversion {
    public static void main(String[] args) {

        System.out.println("Enter the date and time in the format 22.01.2019 19:15:00");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        System.out.println(dateFormatting(line));

    }

    private static String dateFormatting(String inputString) {

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");
        Date parsingDate;

        try {
            parsingDate = format.parse(inputString); // переводит строку в дату согласно с паттерном
        } catch (ParseException e) {
            return "Incorrect input, try again!";
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("dd MMM, K:mm a");

        return outFormat.format(parsingDate);
    }

}
/*
 Задана строка с датой вида "22.01.2019 19:15:00". Написать метод который преобразовывает ее в формат "22 Jan, 7:15 PM". Предусмотреть обработку ситуации если входящая дата в недопустимом формате.
 */

//  System.out.printf(" %1$td %1$tb, %1$tl:%1$tM %1$Tp", parsingDate);