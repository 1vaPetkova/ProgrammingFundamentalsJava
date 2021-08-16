package T09regularExpressions.moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02RageQuitv3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern mPattern = Pattern.compile("[^0-9]+");
        Pattern repPattern = Pattern.compile("[0-9]+");
        Matcher mMatcher = mPattern.matcher(input);
        Matcher repMatcher = repPattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (mMatcher.find() && repMatcher.find()) {
            String message = mMatcher.group();
            int reps = Integer.parseInt(repMatcher.group());
            sb.append(message.toUpperCase().repeat(reps));
        }
            //FIND UNIQUE CHARS!!!!!
        System.out.println("Unique symbols used: " + sb.chars().distinct().count());
        System.out.println(sb);
    }
}
