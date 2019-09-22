import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class ReadFromFile {
        public static void main(String[] args) {

            StringBuilder sb = new StringBuilder();
            readFromFile(sb);
            String json = sb.toString();

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            Type type = new TypeToken<GroupPersons>() {}.getType();
            GroupPersons read = gson.fromJson(json, type);

            System.out.println(read);

        }

        private static void readFromFile(StringBuilder sb) {
            try (BufferedReader br = new BufferedReader(new FileReader("Person.json"))) {
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    sb.append(currentLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
