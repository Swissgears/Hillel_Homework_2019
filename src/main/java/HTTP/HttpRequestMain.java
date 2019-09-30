package HTTP;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static HTTP.HttpRequest.getFileSizeBytes;

public class HttpRequestMain {

    private static String URL = "https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java";
    static final String FILE_NAME = "TEST.java";

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        // get size
        HttpRequest.Response headResponse = HttpRequest.sendRequest(URL, "HEAD", null);
        int size = Integer.parseInt(headResponse.headers.get("Content-Length").get(0));
        System.out.println("Content-Length: " + size);

        File file = new File(FILE_NAME);
        if (file.exists() || file.isFile()) {

            // load first part

            map.put("Range", "bytes=0-" + size / 2);
            String result = HttpRequest.sendRequest(URL, "GET", map).response;
            HttpRequest.writeToFile(result, FILE_NAME);

            System.out.print("Number of bytes downloaded: " + getFileSizeBytes(file));

            if (getFileSizeBytes(file) == (size / 2) + 1) {// 1106+1

                // load second part
                map = new HashMap<>();
                map.put("Range", "bytes=" + size / 2);
                result = HttpRequest.sendRequest(URL, "GET", map).response;
                HttpRequest.writeToFile(result, FILE_NAME);
                System.out.print(" -> " + getFileSizeBytes(file));
            }

            if (getFileSizeBytes(file) == size) {
                System.out.println(" -> File downloaded");

            } else System.out.print(" -> File not uploaded");
        } else System.out.print("File does not exist or is not a file!");
    }
}
/*
Взять файл по прямой ссылке, например

https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java

Скачать этот файл, за 2 запроса, первую половину и докачать вторую половину.
 */