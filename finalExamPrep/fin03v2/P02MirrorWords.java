package finalExamPrep.fin03v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String[]> matchingWords = new ArrayList<>();
        int pairs = 0;
        while (matcher.find()) {
            pairs++;
            String firstWord = matcher.group("wordOne");
            String secondWord = matcher.group("wordTwo");
            StringBuilder sb = new StringBuilder(secondWord);

            if (firstWord.equals(sb.reverse().toString())) {
                String[] str = new String[2];
                str[0] = firstWord;
                str[1] = secondWord;
                matchingWords.add(str);
            }
        }

        StringBuilder output = new StringBuilder();
        if (pairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairs + " word pairs found!");
        }
            if (matchingWords.isEmpty()) {
                System.out.println("No mirror words!");
            } else {
                output.append("The mirror words are:\n");
                matchingWords.forEach(e -> output.append(String.format("%s <=> %s, ", e[0], e[1])));
                System.out.println(output.substring(0, output.length() - 2));
            }
        }
    }

