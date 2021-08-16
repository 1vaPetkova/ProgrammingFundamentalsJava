package finalExamPrep.extra;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02Deciphering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([d-z{}\\|#]+)$");
        String input = scan.nextLine();
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String[] encrypted = input.split("");
            StringBuilder sb = new StringBuilder();
            Arrays.stream(encrypted).forEach(e -> sb.append((char) ((int) e.charAt(0) - 3)));
            String[] substrings = scan.nextLine().split(" ");
            System.out.println(sb.toString().replace(substrings[0], substrings[1]));
        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
