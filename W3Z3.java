import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        File[] files = {
                new File("file1.txt"),
                new File("directory1"),
                new File("file2.txt"),
                new File("directory2")
        };

        Arrays.sort(files, (File f1, File f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().compareTo(f2.getName());
            }
        });

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}