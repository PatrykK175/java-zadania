import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }

    private static boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
        for (int i = 0; i < strings.size() - 1; i++) {
            if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("banana");
        strings.add("apple");
        strings.add("cherry");

        Comparator<String> comp = String::compareTo;

        luckySort(strings, comp);

        for (String s : strings) {
            System.out.println(s);
        }
    }
}