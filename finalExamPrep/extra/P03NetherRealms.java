package finalExamPrep.extra;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] participants = scan.nextLine().split("\\s*,\\s*");
        Pattern healthPattern = Pattern.compile("([^0-9+\\-*\\/.])");
        Pattern operatorsPattern = Pattern.compile("[*\\/]");
        Pattern numberPattern = Pattern.compile("[+-]?[0-9]+[.]?[0-9]*");
        ArrayDeque<Character> operators = new ArrayDeque<>();
        Map<String, double[]> demons = new TreeMap<>();
        for (String p : participants) {
            Matcher hMatcher = healthPattern.matcher(p);
            Matcher oMatcher = operatorsPattern.matcher(p);
            Matcher numberMatcher = numberPattern.matcher(p);
            double health = 0;
            while (hMatcher.find()) {
                char current = hMatcher.group(0).charAt(0);
                health += (int) current;
            }
            double damage = 0;
            while (oMatcher.find()) {
                operators.offer(oMatcher.group().charAt(0));
            }
            while (numberMatcher.find()) {
                damage += Double.parseDouble(numberMatcher.group());
            }
            while (!operators.isEmpty()) {
                if (operators.peek() == '*') {
                    damage *= 2;
                } else if (operators.peek() == '/') {
                    damage /= 2;
                }
                operators.poll();
            }
            demons.put(p, new double[]{health, damage});
        }
        demons.forEach((k, v) -> System.out.printf("%s - %.0f health, %.2f damage\n", k, v[0], v[1]));
    }
}
