package T08textProcessing.archive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        String first=words[0];
        String second=words[1];
        System.out.println(areExchangeable(first, second));
    }

    private static boolean areExchangeable(String first, String second) {
        long f = first.chars().distinct().count();
        long s = second.chars().distinct().count();
        if (f != s) {
            return false;
        }
        return true;
    }
}


