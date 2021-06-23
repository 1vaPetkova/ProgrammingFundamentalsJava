package finalExamPrep.fin05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetectorv3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> emojis = new ArrayList<>();
        Pattern pDigits = Pattern.compile("[0-9]");
        Pattern pEmoji = Pattern.compile("([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        int coolThreshold = 1;

        Matcher mDigits = pDigits.matcher(input);

        while (mDigits.find()) {
            coolThreshold *= Integer.parseInt(mDigits.group());
        }

        Matcher mEmoji = pEmoji.matcher(input);
        while (mEmoji.find()) {
            emojis.add(mEmoji.group());
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojis.size());
        for (String emoji : emojis) {
            int sumAscii = 0;
            for (int i = 0; i < emoji.length(); i++) {
                if (Character.isLetter(emoji.charAt(i))) {
                    sumAscii += emoji.charAt(i);
                }
            }
            if (sumAscii > coolThreshold) {
                System.out.println(emoji);
            }
        }
    }
}
