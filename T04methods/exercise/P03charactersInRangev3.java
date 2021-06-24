package T04methods.exercise;

import java.util.Scanner;

public class P03charactersInRangev3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        returnCharactersInRange(firstChar, secondChar);
    }

    private static void returnCharactersInRange(char firstChar, char secondChar) {
        int min = Math.min(firstChar,secondChar);
        int max = Math.max(firstChar,secondChar);
        for (int i = min + 1; i < max; i++) {
            System.out.print((char)(i) + " ");
        }
    }
}
