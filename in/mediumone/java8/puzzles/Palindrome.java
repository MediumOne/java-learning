package in.mediumone.java8.puzzles;

public class Palindrome {

    public static void main(String[] args) {

        int input = 1212;

        String inputStr = input + "";

        String reverseStr = reverseString(inputStr);

        boolean isPalindrome = inputStr.equalsIgnoreCase(reverseStr);

        System.out.println("Is " + input + " a palindrome?: " + isPalindrome);
    }

    private static String reverseString(String input) {

        char[] inputChars = input.toCharArray();

        int inputLen = inputChars.length;

        char[] reverseChars = new char[inputLen];

        for(int i = 0; i < inputLen; i++) {
            reverseChars[inputLen - i - 1] = inputChars[i];
        }

        return new String(reverseChars);
    }
}
