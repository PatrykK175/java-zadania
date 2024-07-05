import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        Stream<Double> stream = numbers.stream();

        double[] result = stream.reduce(
                new double[2],
                (acc, value) -> new double[]{acc[0] + value, acc[1] + 1},
                (acc1, acc2) -> new double[]{acc1[0] + acc2[0], acc1[1] + acc2[1]}
        );

        double sum = result[0];
        double count = result[1];
        double average = sum / count;

        System.out.println("Average: " + average);
    }
}