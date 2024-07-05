import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "elephant", "tiger", "hippopotamus", "rhinoceros", "giraffe",
                "alligator", "crocodile", "chimpanzee", "orangutan", "gorilla"
        );

        Stream<String> stream = words.stream().filter(word -> {
            System.out.println("Filtering: " + word);
            return word.length() > 5;
        });

        stream.limit(5).forEach(System.out::println);
    }
}