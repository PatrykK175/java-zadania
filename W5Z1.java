import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(7, 8, 9));

        Stream<ArrayList<Integer>> stream = Stream.of(list1, list2, list3);

        ArrayList<Integer> result1 = stream.reduce(new ArrayList<>(), (acc, list) -> {
            acc.addAll(list);
            return acc;
        });

        System.out.println("Result using identity and accumulator: " + result1);

        stream = Stream.of(list1, list2, list3);

        ArrayList<Integer> result2 = stream.reduce((list1Acc, list2Acc) -> {
            list1Acc.addAll(list2Acc);
            return list1Acc;
        }).orElse(new ArrayList<>());

        System.out.println("Result using accumulator and combiner: " + result2);

        stream = Stream.of(list1, list2, list3);

        ArrayList<Integer> result3 = stream.reduce(new ArrayList<>(),
                (acc, list) -> {
                    acc.addAll(list);
                    return acc;
                },
                (list1Acc, list2Acc) -> {
                    list1Acc.addAll(list2Acc);
                    return list1Acc;
                });

        System.out.println("Result using identity, accumulator, and combiner: " + result3);
    }
}