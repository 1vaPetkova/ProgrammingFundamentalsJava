package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P06charToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder wordBuilder = new StringBuilder();
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        char thirdChar = scan.nextLine().charAt(0);
        wordBuilder.append(firstChar);
        wordBuilder.append(secondChar);
        wordBuilder.append(thirdChar);
        String word = wordBuilder.toString();
        System.out.println(word);
    }
}
