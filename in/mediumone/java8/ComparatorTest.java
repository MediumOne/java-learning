package in.mediumone.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

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

        Comparator<String> strLenComparator = (lhs, rhs) -> Integer.compare(lhs.length(), rhs.length());

        Comparator<String> strLenComparator2 = Comparator.comparingInt(String::length);

        lambdasPart2();
    }

    private static List<Person> people = Arrays.asList(
            new Person("Ted", "Neward", 42),
            new Person("Charlotte", "Neward", 39),
            new Person("Michael", "Neward", 19),
            new Person("Matthew", "Neward", 13),
            new Person("Neal", "Ford", 45),
            new Person("Candy", "Ford", 39),
            new Person("Jeff", "Brown", 43),
            new Person("Betsy", "Brown", 39)
    );

    public static final void lambdasPart2() {
        System.out.println(people);

        Collections.sort(people, Person.BY_LAST.thenComparing(Person.BY_AGE));

        System.out.println(people);

        people.stream()
                .filter(it -> it.getAge() > 21)
                .forEach(it -> System.out.println("Have a beer, " + it.getFirstName()));

        Predicate<Person> drinkingAge = it -> it.getAge() > 21;
        Predicate<Person> browns = it -> it.getLastName().equals("Brown");

        people.stream()
                .filter(drinkingAge.and(browns))
                .forEach((it) -> System.out.println("Have a beer, " + it.getLastName()));
    }
}
