package T08textProcessing.archive;

import java.util.*;

public class P05MagicExchangeableWordsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        char[] f = words[0].toCharArray();
        char[] s = words[1].toCharArray();

        HashSet<Character> firstWord = new HashSet<>();
        for (Character ch1 : f) {
            firstWord.add(ch1);
        }
        HashSet<Character> secondWord = new HashSet<>();
        for (Character ch2 : s) {
            secondWord.add(ch2);
        }
        System.out.println(firstWord.size() == secondWord.size() ? "true" : "false");
    }
}


