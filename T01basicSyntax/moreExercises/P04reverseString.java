package T01basicSyntax.moreExercises;

import java.util.Scanner;

public class P04reverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder outputBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            outputBuilder.append(letter);
        }
        String output = outputBuilder.toString();
        System.out.println(output);
    }
}
