package in.mediumone.java8;

import java.util.Comparator;

public class Person {

    private String firstName;
    private String lastName;

    private int age;

    public Person(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static final Comparator<Person> BY_LAST_AND_AGE = (lhs, rhs) -> {
        if(lhs.getLastName().equals(rhs.getLastName())) {
            return lhs.getAge() - rhs.getAge();
        } else {
            return lhs.getLastName().compareTo(rhs.getLastName());
        }
    };

    public static final Comparator<Person> BY_FIRST= (lhs, rhs) -> lhs.getFirstName().compareTo(rhs.getFirstName());
    public static final Comparator<Person> BY_LAST= (lhs, rhs) -> lhs.getLastName().compareTo(rhs.getLastName());
    public static final Comparator<Person> BY_AGE= (lhs, rhs) -> lhs.getAge() - rhs.getAge();

    public static final Comparator<Person> BY_FIRST_2 = Comparator.comparing(Person::getFirstName);
    public static final Comparator<Person> BY_LAST_2 = Comparator.comparing(Person::getLastName);
    public static final Comparator<Person> BY_AGE_2 = Comparator.comparingInt(Person::getAge);

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}