package in.mediumone.java8;

import java.util.List;

public class Employee {

    public String name;

    public int age;

    private List<String> locations;

    public Employee(String name, int age, List<String> locations) {
        this.name = name;
        this.age = age;
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", locations=" + locations +
                '}';
    }
}
