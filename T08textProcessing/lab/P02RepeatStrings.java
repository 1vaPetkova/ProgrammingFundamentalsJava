package T08textProcessing.lab;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");
        for (String word : arr) {
            String repeatedWord = repeatedWord(word, word.length());
            System.out.print(repeatedWord);
        }
    }

    private static String repeatedWord(String word, int repetitions) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            result.append(word);
        }
        return result.toString();
    }
}
