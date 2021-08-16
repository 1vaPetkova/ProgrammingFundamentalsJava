package T08textProcessing.archive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05MagicExchangeableWords_v3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        System.out.println(areExchangeable(words[0], words[1]));
    }

    private static boolean areExchangeable(String first, String second) {
        //firstWordChars <-> secondWord chars
        Map<Character, Character> pairs = new LinkedHashMap<>();
        int minLength = Math.min(first.length(), second.length());
        for (int i = 0; i < minLength; i++) {
            char f = first.charAt(i);
            char s = second.charAt(i);
            if (!pairs.containsKey(f)) {
                if (pairs.containsValue(s)) {
                    return false;
                }
                pairs.put(f, s);
            } else if (pairs.get(f) != s) {
                return false;
            }
        }
        String substring = "";
        if (first.length() > second.length()) {
            substring = first.substring(minLength);
            return substring.chars().anyMatch(c->pairs.containsKey((char) c));
        } else if (first.length() < second.length()) {
            substring = second.substring(minLength);
           return substring.chars().anyMatch(c->pairs.containsValue((char) c));
        }
        return true;
    }

}
