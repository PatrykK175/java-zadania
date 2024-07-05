import java.io.File;
import java.io.FileFilter;

public class Main {
    public static File[] getSubdirectoriesLambda(File directory) {
        return directory.listFiles(file -> file.isDirectory());
    }

    public static File[] getSubdirectoriesAnonymousClass(File directory) {
        return directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
    }

    public static void main(String[] args) {
        File directory = new File("path/to/directory");

        File[] subdirsLambda = getSubdirectoriesLambda(directory);
        for (File subdir : subdirsLambda) {
            System.out.println(subdir.getName());
        }

        File[] subdirsAnonymousClass = getSubdirectoriesAnonymousClass(directory);
        for (File subdir : subdirsAnonymousClass) {
            System.out.println(subdir.getName());
        }
    }
}