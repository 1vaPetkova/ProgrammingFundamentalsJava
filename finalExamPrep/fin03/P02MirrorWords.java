package finalExamPrep.fin03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([@|#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        Map<String, String> pairs = new LinkedHashMap<>();
        int countPairs = 0;
        int countMatches = 0;
        boolean isFound = false;
        while (matcher.find()) {
            isFound = true;
            countPairs++;
            String wordOne = matcher.group("wordOne");
            StringBuilder wordTwo = new StringBuilder(matcher.group("wordTwo"));
            if (wordTwo.reverse().toString().equals(wordOne)) {
                countMatches++;
                pairs.putIfAbsent(wordOne, "");
                pairs.put(wordOne, wordTwo.reverse().toString());
            }
        }
        StringBuilder output = new StringBuilder();
        if (!isFound) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(countPairs + " word pairs found!");
        }
        if (countMatches == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            pairs.forEach((k, v) ->
                    output.append(String.format("%s <=> %s, ", k, v)));
            System.out.print(output.substring(0, output.length() - 2));
        }
    }
}
