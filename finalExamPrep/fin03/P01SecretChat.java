package finalExamPrep.fin03;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String concealedMessage = scan.nextLine();
        String input = "";
        while (!(input = scan.nextLine()).equals("Reveal")) {
            switch (input.split(":\\|:")[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(input.split(":\\|:")[1]);
                    StringBuilder amended = new StringBuilder(concealedMessage);
                    amended.insert(index, " ");
                    concealedMessage = amended.toString();
                    break;
                case "Reverse":
                    String substring = input.split(":\\|:")[1];
                    if (concealedMessage.contains(substring)) {
                        StringBuilder newPart = new StringBuilder(concealedMessage);
                        StringBuilder reversed = new StringBuilder(substring);
                        int indexOfSubstring = concealedMessage.indexOf(substring);
                        newPart.replace(indexOfSubstring, indexOfSubstring + substring.length(), "");
                        reversed.reverse();
                        newPart.append(reversed);
                        concealedMessage = newPart.toString();
                    } else {
                        System.out.println("error");
                        continue;
                    }
                    break;
                case "ChangeAll":
                    String part = input.split(":\\|:")[1];
                    String replacement = input.split(":\\|:")[2];
                    if (concealedMessage.contains(part)) {
                        concealedMessage = concealedMessage.replace(part, replacement);
                    }
                    break;
            }
            System.out.println(concealedMessage);
        }
        System.out.println("You have a new text message: " + concealedMessage);
    }
}
