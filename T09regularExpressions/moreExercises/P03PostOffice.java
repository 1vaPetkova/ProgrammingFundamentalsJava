package T09regularExpressions.moreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        Pattern pCapitals = Pattern.compile("([#$%*&])(?<cap>[A-Z]+)\\1");
        Matcher mCapitals = pCapitals.matcher(input[0]);
        Map<Character, Integer> map = new LinkedHashMap<>();
        while (mCapitals.find()) {
            String capLetters = mCapitals.group("cap");
            for (int i = 0; i < capLetters.length(); i++) {
                map.putIfAbsent(capLetters.charAt(i), 0);
            }
        }

        Pattern pAsciiAndLength = Pattern.compile("(?<ascii>[\\d]{2}):(?<length>[\\d]{2})");
        Matcher mAsciiAndLength = pAsciiAndLength.matcher(input[1]);
        while (mAsciiAndLength.find()) {
            int currSymbol = Integer.parseInt(mAsciiAndLength.group("ascii"));
            int currLength = Integer.parseInt(mAsciiAndLength.group("length"));
            for (Map.Entry<Character, Integer> ch : map.entrySet()) {
                if (currSymbol == ch.getKey()) {
                    map.put(ch.getKey(), currLength+1);
                }
            }
        }
        List<String> words = Arrays.stream(input[2].split("\\s+"))
                .collect(Collectors.toList());
        map.forEach((k, v) -> words.stream().filter(w -> w.length() == v && w.charAt(0) == k)
        .forEach(System.out::println));
    }
}
