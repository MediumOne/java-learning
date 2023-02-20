package in.mediumone.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Landor", "Fry", "Hitchcock", "Lea", "Marquis", "Poe");

        System.out.println("As-is: " + strings);

        Collections.sort(strings);
        System.out.println("Default sorted: " + strings);

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        };

        Collections.sort(strings, lengthComparator);

        Collections.sort(strings, (first, second) -> Integer.compare(first.length(), second.length()));

        System.out.println("Sorted by length: " + strings);
    }
}
