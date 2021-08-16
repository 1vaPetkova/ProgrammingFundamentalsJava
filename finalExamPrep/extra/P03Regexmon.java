package finalExamPrep.extra;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03Regexmon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern patternPokeword = Pattern.compile("([A-Za-z]+)-([A-Za-z]+)");
        Pattern everythingElse = Pattern.compile("([^A-Za-z-]+)");
        StringBuilder txt = new StringBuilder(scan.nextLine());
        Matcher matcherBojomon = patternPokeword.matcher(txt);
        Matcher matcherDidimon = everythingElse.matcher(txt);
        int turns = 1;
        while (!txt.isEmpty()) {
            String match = "";
            if (turns % 2 != 0) {
                if (matcherDidimon.find()) {
                    match = matcherDidimon.group();
                } else {
                    break;
                }
            } else {
                if (matcherBojomon.find()) {
                    match = matcherBojomon.group();
                } else {
                    break;
                }
            }
            System.out.println(match);
            int index = txt.indexOf(match) + match.length();
            if (match.length() == txt.length()) {
                txt.setLength(0);
                break;
            } else {
                txt = new StringBuilder(txt.substring(index));
            }
            turns++;
        }
    }
}
