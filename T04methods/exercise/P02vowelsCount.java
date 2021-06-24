package T04methods.exercise;

import java.util.Scanner;

public class P02vowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int vowels = countVowelsInString(input);
        System.out.println(vowels);
    }

    private static int countVowelsInString(String input) {
        int countVowels = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            switch (symbol){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    countVowels++;
                    break;
            }
        }
        return countVowels;
    }
}
