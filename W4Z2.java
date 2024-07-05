import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "path/to/war_and_peace.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            long startTime = System.currentTimeMillis();
            long count = lines.stream()
                    .filter(word -> word.length() > 12)
                    .count();
            long endTime = System.currentTimeMillis();
            System.out.println("Stream count: " + count);
            System.out.println("Stream time: " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            count = lines.parallelStream()
                    .filter(word -> word.length() > 12)
                    .count();
            endTime = System.currentTimeMillis();
            System.out.println("Parallel stream count: " + count);
            System.out.println("Parallel stream time: " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}