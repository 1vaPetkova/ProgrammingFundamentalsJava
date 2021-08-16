package T09regularExpressions.moreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();

        Pattern pattern = Pattern.compile("(?<msg>[\\D]+)(?<number>[\\d]+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            int countMsgs = Integer.parseInt(matcher.group("number"));
            result.append(String.valueOf(matcher.group("msg")).repeat(Math.max(0, countMsgs)));
        }
        System.out.printf("Unique symbols used: %d\n", result.chars().distinct().count());
        System.out.println(result);
    }
}