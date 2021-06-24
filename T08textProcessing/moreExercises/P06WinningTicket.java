package T08textProcessing.moreExercises;

import java.util.Scanner;

public class P06WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().replaceAll("\\s+", "").split(",");

        for (String s : tickets) {
            if (s.length() == 20) {
                String left = getLeftRight(s.substring(0, 10));
                String right = getLeftRight(s.substring(10));
                if (left.charAt(0) == right.charAt(0) && left.length() >= 6 && right.length() >= 6) {
                    if (left.length() == 10 && right.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!\n", s, left.length(), left.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c\n", s, Math.min(left.length(), right.length()), left.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", s);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }

    private static String getLeftRight(String part) {
        StringBuilder output = new StringBuilder();
        char symbol;
        for (int i = 0; i < part.length(); i++) {
            if (isSpecialSymbol(part.charAt(i))) {
                symbol = part.charAt(i);
                output.append(symbol);
                for (int j = i + 1; j < part.length(); j++) {
                    if (part.charAt(j) == symbol) {
                        output.append(part.charAt(j));
                    } else {
                        break;
                    }
                }
            }
            if (output.length() >= 6) {
                return output.toString();
            } else {
                if (i > 4) {
                    break;
                }
                output.setLength(0);
            }
        }
        return " ";
    }


    private static boolean isSpecialSymbol(char ch) {
        switch (ch) {
            case '@':
            case '#':
            case '$':
            case '^':
                return true;
        }
        return false;
    }
}
