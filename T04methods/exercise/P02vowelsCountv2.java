package T04methods.exercise;

import java.util.Scanner;

public class P02vowelsCountv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int vowels = countVowelsInString(input);
        System.out.println(vowels);
    }

    private static int countVowelsInString(String input) {
        int countVowels = 0;
        String[] symbols = input.split("");
        for (int i = 0; i < input.length(); i++) {
            if (symbols[i].equalsIgnoreCase("a")
                    || symbols[i].equalsIgnoreCase("e")
                    || symbols[i].equalsIgnoreCase("i")
                    || symbols[i].equalsIgnoreCase("o")
                    || symbols[i].equalsIgnoreCase("u")){
                countVowels++;
            }
        }
        return countVowels;
    }
}
