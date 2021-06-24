package T08textProcessing.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> text = Arrays.stream(scan.nextLine().split(""))
                .collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < text.size() - 1; i++) {

            if (text.get(i).equals(text.get(i + 1))) {
                text.remove(i + 1);
                i--;
            }
        }
        System.out.println(String.join("",text));
    }
}



