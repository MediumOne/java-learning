package in.mediumone.java8.puzzles;

import java.util.stream.Stream;

public class PalindromeImproved {

    public static void main(String[] args) {

        int input = 121;

        String inputStr = input + "";

        String reverseStr = inputStr.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);

        System.out.println(reverseStr);

        boolean isPalindrome = inputStr.equalsIgnoreCase(reverseStr);

        System.out.println("Is " + input + " a palindrome?: " + isPalindrome);
    }

    private static String reverseString(String input) {

        char[] inputChars = input.toCharArray();

        int inputLen = inputChars.length;

        char[] reverseChars = new char[inputLen];

        for (int i = 0; i < inputLen; i++) {
            reverseChars[inputLen - i - 1] = inputChars[i];
        }

        return new String(reverseChars);
    }
}
