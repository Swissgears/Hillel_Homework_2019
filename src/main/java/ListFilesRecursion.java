import java.io.File;

public class ListFilesRecursion {
    public static void main(String[] args) {

        String pathToFile = new File("").getAbsolutePath();
        getDirs(pathToFile);
    }

    private static void getDirs(String pathToFile) {
        File dir = new File(pathToFile);
        for (File item : dir.listFiles()) {

            if (item.isDirectory()) {
                getDirs(item.getAbsolutePath());

            } else {
                System.out.println(item.getName());
            }
        }
    }
}

/*
 Вывести список файлов текущей директории рекурсивно (только файлов без директорий)
 */

