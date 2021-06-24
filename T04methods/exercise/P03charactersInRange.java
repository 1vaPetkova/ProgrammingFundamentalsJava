package T04methods.exercise;

import java.util.Scanner;

public class P03charactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);

        char[] characters = returnCharactersInRange(firstChar, secondChar);

        for (int i = 0; i < characters.length; i++) {
            System.out.print(characters[i] + " ");
        }
    }

    private static char[] returnCharactersInRange(char firstChar, char secondChar) {
        int min = Math.min(firstChar,secondChar);
        int diff = Math.abs(firstChar-secondChar);
        char[] chars = new char[diff-1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (min + 1 + i);
        }
        return chars;
    }
}
