import java.io.FileInputStream;
import java.util.zip.*;

public class FilesCounter {
    public static void main(String[] args) {

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("C:/Program Files/Java/jdk-9.0.4/lib/src.zip"))) {

            int filesCounter = 0;

            while ((zin.getNextEntry()) != null) {
                filesCounter++;

                zin.closeEntry();
            }
            System.out.println("Number of files in src.zip: " + filesCounter);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
/*
Подсчитать количество файлов в src.zip который находится в директории JDK
 */
