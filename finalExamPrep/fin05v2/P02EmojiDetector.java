package finalExamPrep.fin05v2;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();
        char[] chars = txt.toCharArray();
        long coolThreshold = 1;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                coolThreshold *= Integer.parseInt(String.valueOf(c));
            }
        }
        Pattern pattern = Pattern.compile("([*]{2}|[:]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(txt);
        List<String> validEmojis = new ArrayList<>();
        int countEmojis=0;
        while (matcher.find()) {
            countEmojis++;
            String emoji = matcher.group("emoji");
            long coolness = 0;
            for (char c : emoji.toCharArray()) {
                coolness += c;
            }
            if (coolness >= coolThreshold) {
                validEmojis.add(matcher.group());
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(countEmojis + " emojis found in the text. The cool ones are:");
        validEmojis.forEach(System.out::println);
    }
}
