package T07associativeArrays.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char[] chars = new char[input.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = input.charAt(i);
        }
        Map<Character, Integer> charsCount = new LinkedHashMap<>();

        for (char symbol : chars) {
            if (symbol!=' ') {
                if (!charsCount.containsKey(symbol)) {
                    charsCount.put(symbol, 1);
                } else {
                    charsCount.put(symbol, charsCount.get(symbol) + 1);
                }
            }
        }
        charsCount.forEach((k,v)-> System.out.println(k + " -> " + v));
    }
}
