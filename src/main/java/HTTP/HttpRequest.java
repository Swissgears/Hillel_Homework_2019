package HTTP;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    public static class Response {
        int responseCode;
        String response;
        Map<String, List<String>> headers = new HashMap<>();
    }

    public static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(new File(fileName), string, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long getFileSizeBytes(File file) {
        return file.length();
    }

    public static Response sendRequest(String url, String requestMethod, Map<String, String> headers) {
        Response result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL requestUrl = new URL(url);
            urlConnection = (HttpURLConnection) requestUrl.openConnection();
            urlConnection.setReadTimeout(20000);
            urlConnection.setConnectTimeout(20000);
            if (requestMethod != null) {
                urlConnection.setRequestMethod(requestMethod); // GET by default
            }

            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            result = new Response();
            result.responseCode = urlConnection.getResponseCode();

            result.headers = urlConnection.getHeaderFields();

            if (result.responseCode == HttpURLConnection.HTTP_OK || result.responseCode == HttpURLConnection.HTTP_PARTIAL) {
                result.response = getStringFromStream(urlConnection.getInputStream());
            }

        } catch (Exception e) {
            System.out.println("sendRequest failed");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;
    }

    private static String getStringFromStream(InputStream inputStream) throws IOException {
        final int BUFFER_SIZE = 4096;
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream(BUFFER_SIZE);
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            resultStream.write(buffer, 0, length);
        }
        return resultStream.toString("UTF-8");
    }


}
