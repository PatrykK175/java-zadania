import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] wartości = { 1, 4, 9, 16 };

        Stream<int[]> streamOfArray = Stream.of(wartości);
        System.out.println("Stream of array: " + streamOfArray.count()); // Output: 1


        IntStream intStream = Arrays.stream(wartości);
        intStream.forEach(System.out::println);
    }
}