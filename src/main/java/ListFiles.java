import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String pathToFile = new File("").getAbsolutePath();
        File dir = new File(pathToFile);

        if (dir.isDirectory()) // если объект представляет каталог
        {
            for (File item : dir.listFiles()) { // получаем все вложенные объекты в каталоге
                if (item.isDirectory()) {

                    String directoryName = item.getName();
                    System.out.println("Directory Name: " + directoryName);
                    File file = new File(directoryName);
                    String[] files = file.list(); // вернётся полный список (массив) имён файлов и каталогов, содержащихся в данном каталоге
                    for (String string : files)
                        System.out.println(string);
                } else {

                    System.out.println(item.getName());
                }
            }
        }
    }
}

        /*
        Вывести список файлов текущей директории
         */
