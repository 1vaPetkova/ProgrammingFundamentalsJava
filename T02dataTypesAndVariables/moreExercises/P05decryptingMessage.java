package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P05decryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int lines = Integer.parseInt(scan.nextLine());
        StringBuilder newBuilder = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            char symbol = scan.nextLine().charAt(0);
            char currentSymbol = (char) (symbol + key);
            newBuilder.append(currentSymbol);
        }
        String output = newBuilder.toString();
        System.out.println(output);
    }
}
