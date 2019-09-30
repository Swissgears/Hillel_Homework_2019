package HTTP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class RequestPostMain {

    private static String URL = "https://postman-echo.com/post";
    static final String FILE_NAME = "TEST.json";

    public static void main(String[] args) {

        String response = RequesPost.sendRequest(URL, "application/x-www-form-urlencoded", "foo1=bar1&foo2=bar2");
        File file = new File(FILE_NAME);
        RequesPost.writeToFile(response, FILE_NAME);

        StringBuilder sb = new StringBuilder();
        RequesPost.readFromFile(sb);
        String json = sb.toString();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Object objectResponse = gson.fromJson(json, Object.class);
        System.out.println(objectResponse);
    }
}

/*
Послать POST запрос на https://postman-echo.com/post где в BODY передать foo1=bar1&foo2=bar2 в формате x-www-form-urlencoded
Ответ распарсить и вывести.
 */

