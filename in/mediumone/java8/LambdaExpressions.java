package in.mediumone.java8;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {

    private static List<String> characters = Arrays.asList("Landor", "Fry", "Hitchcock", "Lea", "Marquis", "Poe");

    public static void main(String[] args) {

        //Runnable
        //Comparator

        //Lambda for Runnable
        Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        t.start();

        //Method reference for Runnable. So hard to understand.
        Thread t2 = new Thread(System.out::println); //The run() in runnable takes no parameter. So this does not print anything.
        t2.start();

        //Lambda for Comparator
        Collections.sort(characters, (first, second) -> Integer.compare(first.length(), second.length()));
        System.out.println(characters);

        //Method Reference for Comparator. So hard to understand!
        Collections.sort(characters, LambdaExpressions::compareLocal); //The compare method in Comparator has two parameters. Those are passed in to this compareLocal method.
        System.out.println(characters);

        // 1.4 Types of Method References. Confusing!

        // 1.5 Constructor References

        //Exercises - 1.1
        exercise1_1();

        exercise1_2_a();
        exercise1_2_b();

        exercise1_3();

        exercise1_4();
    }

    private static void exercise1_1() {
        System.out.println("Method thread name: " + Thread.currentThread().getName());

        Arrays.sort(characters.toArray(String[]::new),  (first, second) -> {
            System.out.println("Lambda thread name: " + Thread.currentThread().getName());
            return Integer.compare(first.length(), second.length());
        });
    }

    /**
     * Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
     * write a method that returns all subdirectories of a given directory. Use a
     * lambda expression instead of a FileFilter object. Repeat with a method
     * expression.
     */
    private static void exercise1_2_a() {
        File directory = new File("/");

        //Using Lambda Expression

        File[] listFiles = directory.listFiles(fileOrDir -> {
            System.out.println("File being checked:" + fileOrDir.getAbsolutePath());
            return fileOrDir.isDirectory();
        });

        System.out.println("Directories");

        Arrays.asList(listFiles).forEach((file) -> System.out.println(file.getAbsolutePath()));
    }

    private static void exercise1_2_b() {
        File directory = new File("/");

        //Using Lambda Expression

        File[] listFiles = directory.listFiles(LambdaExpressions::filterDirectories);

        System.out.println("Directories");

        Arrays.asList(listFiles).forEach((file) -> System.out.println(file.getAbsolutePath()));
    }

    private static boolean filterDirectories(File pathname) {
        System.out.println("File being checked:" + pathname.getAbsolutePath());
        return pathname.isDirectory();
    }

    private static int compareLocal(String first, String second) {
        return Integer.compare(first.length(), second.length());
    }

    /**
     * Using the list(FilenameFilter) method of the java.io.File class, write a method
     * that returns all ﬁles in a given directory with a given extension. Use a lambda
     * expression, not a FilenameFilter. Which variables from the enclosing scope does
     * it capture?
     */
    private static void exercise1_3() {
        File directory = new File("/home/sivasubramaniam/Downloads");

        //Using Lambda Expression

        String[] webms = directory.list((dir, name) -> name.contains("webm"));

        System.out.println("WebM Files");

        Arrays.asList(webms).forEach(System.out::println);
    }

    /**
     * Given an array of File objects, sort it so that the directories come before the
     * ﬁles, and within each group, elements are sorted by path name. Use a lambda
     * expression, not a Comparator.
     */
    private static void exercise1_4() {
        File directory = new File("/home/sivasubramaniam/Downloads");

        File[] filesAndDirs = directory.listFiles();

        Arrays.sort(filesAndDirs, (first, second) -> {

            if(first.isDirectory() && second.isDirectory()) {
                return first.compareTo(second);
            } else if (!first.isDirectory() && !second.isDirectory()) {
                return first.compareTo(second);
            } else {
                return (first.isDirectory()) ? -1 : 1;
            }
        });

        Arrays.asList(filesAndDirs).forEach(fileName -> System.out.println(fileName.getAbsolutePath()));
    }
}
