package T03arrays.archive;

import java.util.Scanner;

public class P09indexOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("");

        for (int i = 0; i < input.length; i++) {
            char symbol = input[i].charAt(0);
            System.out.printf("%c -> %d%n", symbol, symbol - 'a');
        }
    }
}
