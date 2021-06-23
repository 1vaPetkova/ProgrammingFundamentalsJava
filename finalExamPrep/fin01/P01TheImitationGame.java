package finalExamPrep.fin01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String instructions = "";
        while (!(instructions = scan.nextLine()).equals("Decode")) {
            switch (instructions.split("\\|")[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(instructions.split("\\|")[1]);
                    StringBuilder moveBuilder = new StringBuilder();
                    moveBuilder.append(message);
                    if (numberOfLetters <= message.length()) {
                        for (int i = 0; i < numberOfLetters; i++) {
                            moveBuilder.append(message.charAt(i));
                        }
                    }
                    moveBuilder.replace(0, numberOfLetters, "");
                    message = moveBuilder.toString();
                    break;
                case "Insert":
                    int index = Integer.parseInt(instructions.split("\\|")[1]);
                    String value = instructions.split("\\|")[2];
                    StringBuilder insertBuilder = new StringBuilder();
                    insertBuilder.append(message);
                    if (index >= 0 && index <= message.length()) {
                        insertBuilder.insert(index, value);
                    }
                    message = insertBuilder.toString();
                    break;
                case "ChangeAll":
                    String substring = instructions.split("\\|")[1];
                    String replacement = instructions.split("\\|")[2];
                    message = message.replace(substring, replacement);
                    break;
            }
        }
        System.out.printf("The decrypted message is: %s", message);
    }
}
