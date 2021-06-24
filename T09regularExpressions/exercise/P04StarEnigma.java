package T09regularExpressions.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<String> listAttacked = new ArrayList<>();
        List<String> listDestroyed = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String input = scan.nextLine();
            //count symbols
            int countStar = countStar(input);
            //encrypt message
            StringBuilder messageBuilder = new StringBuilder();
            for (int k = 0; k < input.length(); k++) {
                messageBuilder.append((char) (input.charAt(k) - countStar));
            }
            String message = messageBuilder.toString();
            //read elements from the encrypted
            Pattern pattern = Pattern.compile("@(?<planet>[A-Za-z]+)(?:[^@\\-!:>]*?)" +
                    ":(?<population>\\d+)(?:[^@\\-!:>]*?)" +
                    "!(?<attackType>[AD])!(?:[^@\\-!:>]*?)" +
                    "->(?<soldiers>\\d+)(?:.*)");
            Matcher matcher = pattern.matcher(message);
            //sort elements
            if (matcher.find()) {
                if (matcher.group("attackType").equals("A")) {
                    listAttacked.add(matcher.group("planet"));
                } else if (matcher.group("attackType").equals("D")) {
                    listDestroyed.add(matcher.group("planet"));
                }
            }
        }

        System.out.println("Attacked planets: " + listAttacked.size());
        //print
        if (!listAttacked.isEmpty()) {
            listAttacked.stream().sorted().forEach(p -> System.out.println("-> " + p));
        }

        System.out.println("Destroyed planets: " + listDestroyed.size());
        if (!listDestroyed.isEmpty()) {
            listDestroyed.stream().sorted().forEach(p -> System.out.println("-> " + p));
        }
    }

    private static int countStar(String input) {
        int count = 0;
        Pattern patternStar = Pattern.compile("[SsTtAaRr]");
        Matcher matcherStar = patternStar.matcher(input);
        while (matcherStar.find()) {
            count++;
        }
        return count;
    }
}
