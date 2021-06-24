package T08textProcessing.exercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
         encrypted.append((char)(text.charAt(i)+3));
        }
        System.out.println(encrypted);
    }
}
