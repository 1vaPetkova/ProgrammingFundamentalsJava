package finalExamPrep.extra;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P04WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> tickets = Arrays.stream(scan.nextLine().replaceAll("\\s+", "").split(","))
                .collect(Collectors.toList());
        Pattern pattern = Pattern.compile("[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10}");
        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String leftHalf = ticket.substring(0, 10);
                String rightHalf = ticket.substring(10);
                Matcher leftMatcher = pattern.matcher(leftHalf);
                Matcher rightMatcher = pattern.matcher(rightHalf);
                if (leftMatcher.find() && rightMatcher.find()
                        && leftMatcher.group().charAt(0) == rightMatcher.group().charAt(0)) {
                    String leftWin = leftMatcher.group();
                    String rightWin = rightMatcher.group();
                    if (leftWin.length() == 10 && rightWin.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!\n",
                                ticket, leftWin.length(), leftWin.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c\n",
                                ticket, Math.min(leftWin.length(), rightWin.length()), leftWin.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            }
        }
    }
}
