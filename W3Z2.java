import java.io.File;

public class Main {
    public static String[] getFilesWithExtension(File directory, String extension) {
        return directory.list((dir, name) -> name.endsWith(extension));
    }

    public static void main(String[] args) {
        File directory = new File("path/to/directory");
        String extension = ".txt";

        String[] files = getFilesWithExtension(directory, extension);
        for (String file : files) {
            System.out.println(file);
        }
    }
}