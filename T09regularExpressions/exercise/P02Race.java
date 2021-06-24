package T09regularExpressions.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> participants = Arrays.stream(scan.nextLine().trim().split(",\\s+"))
                .collect(Collectors.toList());
        String input = "";
        Pattern patternLetter = Pattern.compile("[A-Za-z]");
        Pattern patternDigit = Pattern.compile("[0-9]");
        Map<String, Integer> map = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("end of race")) {
            Matcher matcherLetter = patternLetter.matcher(input);
            Matcher matcherDigit = patternDigit.matcher(input);
            StringBuilder currName = new StringBuilder();
            while (matcherLetter.find()) {
                currName.append(matcherLetter.group());
            }
            if (participants.contains(currName.toString())) {
            int currSum = 0;
            while (matcherDigit.find()) {
                currSum += Integer.parseInt(String.valueOf(matcherDigit.group()));
            }
                map.putIfAbsent(currName.toString(), 0);
                map.put(currName.toString(), map.get(currName.toString()) + currSum);
            }
        }

        List<String> result = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("1st place: " + result.get(0));
        System.out.println("2nd place: " + result.get(1));
        System.out.println("3rd place: " + result.get(2));
    }
}
