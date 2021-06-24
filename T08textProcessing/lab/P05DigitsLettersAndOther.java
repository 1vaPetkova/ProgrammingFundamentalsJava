package T08textProcessing.lab;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits.append(input.charAt(i));
            } else if (Character.isAlphabetic(input.charAt(i))) {
                letters.append(input.charAt(i));
            } else {
                symbols.append(input.charAt(i));
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }


}
