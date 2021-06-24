package T04methods.exercise;

import java.util.Scanner;

public class P03charactersInRangev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);

        returnCharactersInRange(firstChar,secondChar);
    }

    private static void returnCharactersInRange(char firstChar, char secondChar) {
        int min = Math.min(firstChar,secondChar);
        int diff = Math.abs(firstChar-secondChar);
        char[] chars = new char[diff-1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (min + 1 + i);
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }

    }
}
