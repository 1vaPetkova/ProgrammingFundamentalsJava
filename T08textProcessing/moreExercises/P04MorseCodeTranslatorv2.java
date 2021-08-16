package T08textProcessing.moreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04MorseCodeTranslatorv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> message = Arrays.stream(scan.nextLine().split(" \\| "))
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < message.size(); i++) {
            result.add(decodedWord(message.get(i)));
        }
        System.out.println(String.join(" ", result));
    }


    private static String decodedWord(String word) {
        String[] morseCodeLetters = word.split("\\s+");
        StringBuilder currWord = new StringBuilder();
        char[] englishLetter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (int i = 0; i < morseCodeLetters.length; i++) {
            String currentLetter = morseCodeLetters[i];
            if (Arrays.asList(codes).contains(currentLetter)) {
                int currentLetterIndex = getIndex(codes, currentLetter);
                currWord.append(englishLetter[currentLetterIndex]);
            }
        }
        return currWord.toString();
    }

    private static int getIndex(String[] codes, String currentLetter) {
        for (int i = 0; i < codes.length; i++) {
            if (codes[i].equals(currentLetter)) {
                return i;
            }
        }
        return 0;
    }
}
