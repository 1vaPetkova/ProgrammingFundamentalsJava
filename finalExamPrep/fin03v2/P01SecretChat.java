package finalExamPrep.fin03v2;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scan.nextLine());
        String input = "";
        while (!(input = scan.nextLine()).equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            switch (tokens[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    message.insert(index, ' ');
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if (message.toString().contains(substring)) {
                        int startIndex = message.indexOf(substring);
                        int endIndex = startIndex + substring.length();
                        message.replace(startIndex, endIndex, "");
                        StringBuilder sb = new StringBuilder(substring);
                        sb.reverse();
                        message.append(sb);
                    } else {
                        System.out.println("error");
                        continue;
                    }
                    break;
                case "ChangeAll":
                    String substr = tokens[1];
                    String replacement = tokens[2];
                    String msg = message.toString().replace(substr, replacement);
                    message = new StringBuilder(msg);
                    break;
            }
            System.out.println(message);
        }
        System.out.println("You have a new text message: " + message);
    }
}
