import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WriteToFile {
    public static void main(String[] args) {

        Gson gson = new Gson();

        GroupPersons groupPersons = new GroupPersons("Java");
        groupPersons.addPersons(new Person("Alex", 10));
        groupPersons.addPersons(new Person("Ben", 20));
        String json = gson.toJson(groupPersons);
        writeToFile(json, "Person.json");
    }

    private static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(new File(fileName), string, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*

1) Создать проект Maven. В корень проекта положить текстовый файл с таким содержимым:

{
  "name": "java",
  "persons": [
    {
      "name": "Alex",
      "age": 22
    },
    {
      "name": "Ben",
      "age": 33
    }
  ]
}
Распарсить этот JSON и вывести обьекты через println().
 */
