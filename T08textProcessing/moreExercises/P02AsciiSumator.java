package T08textProcessing.moreExercises;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstSymbol = scan.nextLine().charAt(0);
        int secondSymbol = scan.nextLine().charAt(0);
        int minSymbol = Math.min(firstSymbol, secondSymbol);
        int maxSymbol = Math.max(firstSymbol, secondSymbol);

        String text = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            int currentSymbol = text.charAt(i);
            if (currentSymbol > minSymbol && currentSymbol < maxSymbol) {
                sum += currentSymbol;
            }
        }
        System.out.println(sum);
    }
}
