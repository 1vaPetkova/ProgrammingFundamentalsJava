package finExam20210814;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String input = "";
        while (!(input = scan.nextLine()).equals("Complete")) {

            if (input.equals("Make Upper")) {
                email = email.toUpperCase(Locale.ROOT);
                System.out.println(email);
            } else if (input.equals("Make Lower")) {
                email = email.toLowerCase(Locale.ROOT);
                System.out.println(email);
            } else if (input.startsWith("GetDomain")) {
                int count = Integer.parseInt(input.split("\\s+")[1]);
                StringBuilder sb = new StringBuilder();
                if (email.length() >= count) {
                    for (int i = email.length() - 1; i >= email.length() - count; i--) {
                        sb.append(email.charAt(i));
                    }
                    System.out.println(sb.reverse());
                }
            } else if (input.startsWith("GetUsername")) {
                if (email.contains("@")) {
                    int index = email.indexOf("@");
                    System.out.println(email.substring(0, index));
                } else {
                    System.out.printf("The email %s doesn't contain the @ symbol.\n", email);
                }
            } else if (input.startsWith("Replace")) {
                String charToReplace = input.split("\\s+")[1];
                email = email.replace(charToReplace, "-");
                System.out.println(email);
            } else if (input.equals("Encrypt")) {
                List<Integer> asciiValues = new ArrayList<>();
                for (int i = 0; i < email.length(); i++) {
                    int value = email.charAt(i);
                    asciiValues.add(value);
                }
                asciiValues.forEach(v -> System.out.print(v + " "));
            }
        }
    }
}
