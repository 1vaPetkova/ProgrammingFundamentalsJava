package T01basicSyntax.exercise;

import java.util.Scanner;

public class P05loginv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        StringBuilder passBuild = new StringBuilder();

        //Обхождаме текста отзад напред
        //Взимаме всеки символ и го добавяме към паролата
        for (int i = username.length() - 1; i >= 0; i--) {
            char letter = username.charAt(i);
            passBuild.append(letter);
        }
        String password = passBuild.toString();
        int attempts = 0;

        boolean isBlocked = false;
        String input = scan.nextLine();
        while (!input.equals(password)) {
            attempts++;
            if (attempts == 4) {
                isBlocked = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scan.nextLine();
        }
        if (isBlocked) {
            System.out.printf("User %s blocked!", username);
        } else {
            System.out.printf("User %s logged in.", username);
        }
    }
}
