package T09regularExpressions.moreExercises;

import javax.sound.sampled.Line;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03PostOfficev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] parts = scan.nextLine().split("\\|");

        Pattern firstP = Pattern.compile("([#$%*&])(?<capitalLetters>[A-Z]+)\\1");
        Matcher firstM = firstP.matcher(parts[0]);
        Map<Character, Integer> map = new LinkedHashMap<>();
        if (firstM.find()) {
            firstM.group("capitalLetters").chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toList())
                    .forEach(c -> map.put(c, 0));
        }
        Pattern secondP = Pattern.compile("([0-9]{2}):([0-9]{2})");
        Matcher secondM = secondP.matcher(parts[1]);
        while (secondM.find()) {
            char firstLetter = (char) Integer.parseInt(secondM.group(1));
            int wordLength = Integer.parseInt(secondM.group(2));
            if (map.containsKey(firstLetter)) {
                map.put(firstLetter, wordLength + 1);
            }
        }
        List<String> words = Arrays.stream(parts[2].split("\\s+"))
                .collect(Collectors.toList());
        map.forEach((k, v) -> words.stream().filter(w -> w.charAt(0) == k && w.length() == v)
                .forEach(System.out::println));
    }
}
