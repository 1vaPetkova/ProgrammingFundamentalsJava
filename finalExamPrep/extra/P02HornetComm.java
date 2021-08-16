package finalExamPrep.extra;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02HornetComm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = "";
        Pattern privateMessagePattern = Pattern.compile("^(\\d+) <-> ([A-Za-z\\d]+)$");
        Pattern broadcastPattern = Pattern.compile("^([\\D]+) <-> ([A-Za-z\\d]+)$");

        List<String> messages = new ArrayList<>();
        List<String> broadcasts = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("Hornet is Green")) {
            Matcher mMatcher = privateMessagePattern.matcher(input);
            Matcher bMatcher = broadcastPattern.matcher(input);
            if (mMatcher.find()) {
                StringBuilder code = new StringBuilder(mMatcher.group(1));
                code.reverse();
                String message = mMatcher.group(2);
                messages.add(code.toString()+" -> "+ message);
            } else if (bMatcher.find()) {
                String message = bMatcher.group(1);
                char[] rightSide = bMatcher.group(2).toCharArray();
                StringBuilder frequency = new StringBuilder();
                for (char c : rightSide) {
                    if (Character.isUpperCase(c)) {
                        frequency.append(String.valueOf(c).toLowerCase());
                    } else if (Character.isLowerCase(c)) {
                        frequency.append(String.valueOf(c).toUpperCase());
                    } else {
                        frequency.append(c);
                    }
                }
                broadcasts.add(frequency.toString()+" -> "+message);
            }
        }
        System.out.println("Broadcasts:");
        if (broadcasts.isEmpty()) {
            System.out.println("None");
        } else {
            broadcasts.forEach(System.out::println);
        }
        System.out.println("Messages:");
        if (messages.isEmpty()) {
            System.out.println("None");
        } else {
            messages.forEach(System.out::println);
        }
    }
}
