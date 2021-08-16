package finalExamPrep.fin01v2;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder(scan.nextLine());
        String input = "";
        while (!(input = scan.nextLine()).equals("Decode")) {
            String[] instructions = input.split("\\|");
            switch (instructions[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(instructions[1]);
                    String partToMove = encryptedMessage.substring(0, numberOfLetters);
                    encryptedMessage.delete(0, numberOfLetters);
                    encryptedMessage.append(partToMove);
                    break;
                case "Insert":
                    int index = Integer.parseInt(instructions[1]);
                    String value = instructions[2];
                    encryptedMessage.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = instructions[1];
                    String replacement = instructions[2];
                    encryptedMessage = new StringBuilder(encryptedMessage.toString().replace(substring, replacement));
                    break;
            }
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}
