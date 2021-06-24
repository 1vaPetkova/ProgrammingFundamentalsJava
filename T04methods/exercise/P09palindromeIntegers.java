package T04methods.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09palindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            int number = Integer.parseInt(input);

            System.out.printf("%b\n", checkIfPalindrome(number));
            input = scan.nextLine();
        }
    }

    private static boolean checkIfPalindrome(int number) {
        boolean isPalindrome = false;
        String input = String.valueOf(number);
        int[] array = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (array.length == 1) {
            isPalindrome = true;
        }
        for (int i = 0; i < array.length / 2; i++) {

            if (array[i] == array[array.length - 1 - i]) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }
}
