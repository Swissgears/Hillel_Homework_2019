import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiteSorter {

    String key;
    Integer value;

    public SiteSorter(String key, int value) {

        this.key = key;
        this.value = value;
    }

    static ArrayList<SiteSorter> siteSorterArrayList = new ArrayList<>();

    public static void main(String[] args) throws MalformedURLException, FileNotFoundException {

        Map<String, Integer> myHashMap = new HashMap<>();

        Integer siteValue = 1;

        File file = new File("C:\\Users\\Sergey\\Desktop\\urls.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine().trim();

            String domainName = new URL("file://" + line).getHost(); // вычленяю из строки имя сайта

            Pattern p = Pattern.compile("([a-z]+\\.([a-z]+\\.)?([a-z]+))");

            Matcher m = p.matcher(domainName);
            if (m.matches()) {

                if (myHashMap.isEmpty()) { // если Мар пуста, кладу в нее значение

                    myHashMap.put(domainName, siteValue);

                } else if (myHashMap.containsKey(domainName)) { // если Мар уже имеет такой ключ, то извлекаю его значение и увеличиваю на 1

                    Integer frequency = myHashMap.get(domainName);

                    myHashMap.put(domainName, frequency == null ? 1 : frequency + 1);

                } else if (!myHashMap.containsKey(domainName)) { // если ключи не совпадают, то кладу новый элемент

                    myHashMap.put(domainName, siteValue);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : myHashMap.entrySet()) {

            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            siteSorterArrayList.add(new SiteSorter(mapKey, mapValue)); // извлекаю ключ и значение, кладу их в ArrayList
            siteSorterArrayList.sort(SiteSorter::compare); // сортирую по значению
        }

//        for (SiteSorter t : siteSorterArrayList) {
// System.out.println(t);
//        }

        System.out.println("Top 10 sites: ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(siteSorterArrayList.get(siteSorterArrayList.size() - i));
        }
    }

    public static int compare(SiteSorter first, SiteSorter second) { // сортировка по значению

        if (first.value == second.value) {
            return 0;
        }
        if (first.value > second.value) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return key + ", frequency = " + value;
    }
}
/*
Есть документ со списком URL.

Вывести топ 10 доменов которые встречаются чаще всего. В документе могут встречается пустые и недопустимые строки.
 */