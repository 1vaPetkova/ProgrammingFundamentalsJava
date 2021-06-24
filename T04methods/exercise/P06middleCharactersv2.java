package T04methods.exercise;

import java.util.Scanner;

public class P06middleCharactersv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        getMiddleCharacters(input);
    }

    private static void getMiddleCharacters(String input) {
        if (input.length() % 2 != 0) {
            System.out.println(input.charAt(input.length()/2));
        } else {
            System.out.print(input.charAt((input.length()/2)-1));
            System.out.print(input.charAt(input.length()/2));
        }
    }
}
