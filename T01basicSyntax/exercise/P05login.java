package T01basicSyntax.exercise;

import java.util.Scanner;

public class P05login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = new StringBuffer(username).reverse().toString();
        String input = scan.nextLine();
        int attempts = 0;
        boolean isBlocked = false;
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
