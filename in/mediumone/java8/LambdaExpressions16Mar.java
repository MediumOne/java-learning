package in.mediumone.java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExpressions16Mar {

    private static List<String> characters = Arrays.asList("Landor", "Fry", "Hitchcock", "Lea", "Marquis", "Poe");

    private static List<List<String>> charactersMatrix = new ArrayList<>();

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

    public static void main(String[] args) {

//        charactersMatrix.add(Arrays.asList("Landor", "Fry", "Hitchcock", "Lea", "Marquis", "Poe"));
//        charactersMatrix.add(Arrays.asList("Neo", "Morpheus", "White Rabbit"));
//
//        characters.stream().sorted().forEach(System.out::println);
//
//        charactersMatrix.stream().flatMap(line -> line.stream()).forEach(System.out::println);

        Predicate<Person> browns = it -> it.getLastName().equals("Neward");
        Predicate<Person> middleAged = it -> it.getAge() > 10;

        people.stream().filter(browns.and(middleAged)).forEach(System.out::println);
    }

    private void runnableTest(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    private static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }

    private void comparatorTest() {

    }


}
