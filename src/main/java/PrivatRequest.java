import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrivatRequest {

    private static String URL;
    static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Enter date in format: 20.09.2019");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine().
                trim();

        if (dateCheck(date)) {

            URL = "https://api.privatbank.ua/p24api/exchange_rates?json&date=" + date;

            String json = HttpUtil.sendRequest(URL, null, null);
            Gson gson = new Gson();
            PrivatResponse response = gson.fromJson(json, PrivatResponse.class);

            HttpURLConnection urlConnection = null;
            try {
                java.net.URL requestUrl = new URL(URL);
                urlConnection = (HttpURLConnection) requestUrl.openConnection();
                urlConnection.setReadTimeout(20000);
                urlConnection.setConnectTimeout(20000);

                int status = urlConnection.getResponseCode();

                if (status == HttpURLConnection.HTTP_OK) {

                    for (ExchangeRate rate : response.getExchangeRate()) {
                        if ("USD".equals(rate.getCurrency())) {
                            System.out.println("Base currency: UAH");
                            System.out.println("currency: USD");
                            System.out.println("Sale Rate: " + rate.getSaleRate());
                            System.out.println("Purchase Rate: " + rate.getPurchaseRate());
                            break;
                        } else counter++;
                    }
                    if (counter == 0) {
                        System.out.println("No data for this day");
                    }
                }
            } catch (Exception e) {
                System.out.println("No connection to the server. Try later");
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        } else System.out.println("Invalid date format!");
    }

    public static boolean dateCheck(String checkString) {

        Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.((19|20)\\d\\d)");
        Matcher m = p.matcher(checkString);
        return m.matches();
    }
}
/*
Используя АПИ приватбанка
https://api.privatbank.ua/p24api/exchange_rates?json&date=30.08.2019
Пользователь вводит дату в консоли, программа должна вывести курс USD за эту дату или сообщение об ошибке.
 */
