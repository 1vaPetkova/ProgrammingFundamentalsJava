package T09regularExpressions.moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().replaceAll("\\s+", "").split(",");
        for (String s : tickets) {
            if (s.length() == 20) {
                Pattern patternHalf = Pattern.compile("[@]{6,10}|[\\^]{6,10}|[$]{6,10}|[#]{6,10}");
                String left = s.substring(0, 10);
                String right = s.substring(10);
                Matcher mLeft = patternHalf.matcher(left);
                Matcher mRight = patternHalf.matcher(right);
                if (mLeft.find() && mRight.find() && mLeft.group().charAt(0) == mRight.group().charAt(0)) {
                   String leftWin = mLeft.group();
                    String rightWin = mRight.group();
                    if (leftWin.length() == 10 && rightWin.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!\n", s, leftWin.length(), leftWin.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c\n", s, Math.min(leftWin.length(), rightWin.length()),
                                                                                            leftWin.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", s);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
