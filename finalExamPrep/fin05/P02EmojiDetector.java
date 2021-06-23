package finalExamPrep.fin05;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pDigits = Pattern.compile("\\d");
        Matcher mDigits = pDigits.matcher(input);
        int coolThreshold = 1;

        while (mDigits.find()) {
            coolThreshold *= Integer.parseInt(mDigits.group());
        }

        Pattern pEmoji = Pattern.compile("([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1");
        Matcher mEmoji = pEmoji.matcher(input);
        int countValid = 0;
        Map<String, Integer> emojis = new LinkedHashMap<>();
        while (mEmoji.find()) {
            countValid++;
            String name = mEmoji.group();
            int sumAscii = 0;
            for (int i = 0; i < name.length(); i++) {
                if(Character.isLetter(name.charAt(i))){
                sumAscii += name.charAt(i);
                }
            }
            emojis.putIfAbsent(name, 0);
            emojis.put(name, sumAscii);
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", countValid);
        int finalCoolThreshold = coolThreshold;
        emojis.entrySet().stream().filter(e -> e.getValue() > finalCoolThreshold).forEach(k -> System.out.println(k.getKey()));
    }
}