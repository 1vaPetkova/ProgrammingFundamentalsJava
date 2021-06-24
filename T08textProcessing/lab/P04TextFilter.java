package T08textProcessing.lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String bannedWord : bannedWords) {
            if(text.contains(bannedWord)){
                String censoredWord = censorWord(bannedWord);
                text = text.replace(bannedWord,censorWord(bannedWord));
            }
        }
        System.out.println(text);
    }

    private static String censorWord(String bannedWord) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bannedWord.length(); i++) {
            result.append("*");
        }
        return result.toString();
    }
}
