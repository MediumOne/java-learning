package in.mediumone.java8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    public static void main(String[] args) {

        Stream<String> song = Stream.of("gently", "down", "the", "stream");

        System.out.println(song.filter(each -> each.length() >= 4).count());

        Stream<String> emptyStream = Stream.empty();

        Stream<String> echos = Stream.generate(() -> "Echo");

//        System.out.println(echos.collect(Collectors.toList()));

//        Stream<Double> doubleStream = Stream.generate(() -> Math.random());
//
//        long bigs = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).count();
//
//        System.out.println(bigs);

        filteredEmployees();
    }

    /**
     * A class Employee has instance variables Name, salary, List of Locations.
     * Given a list of Employees, filter this list using two conditions using Java Streams.
     */
    private static void filteredEmployees() {
        Employee peter = new Employee("Peter", 35, Arrays.asList("Chennai"));
        Employee jane = new Employee("Jane", 28, Arrays.asList("Montana", "Ohio"));
        Employee john = new Employee("John", 63, Arrays.asList("Fort Worth", "Dallas"));
        Employee clint = new Employee("Clint", 90, Arrays.asList("Wild West", "El Dorado"));

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(peter);
        employeeList.add(jane);
        employeeList.add(john);
        employeeList.add(clint);

        System.out.println("Before sorting: " + employeeList);

        List<Employee> collect = employeeList.stream().sorted((first, second) -> first.name.compareTo(second.name)).collect(Collectors.toList());

        System.out.println("After sorting: " + collect);

        collect.stream().filter(employee -> employee.age > 30 && employee.name.startsWith("J")).forEach(employee -> System.out.println(employee.name));

    }
}
