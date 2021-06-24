package T08textProcessing.exercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        double totalSum = 0.00;
        for (String s : input) {
            char firstLetter = s.charAt(0);
            int number = Integer.parseInt(s.substring(1, s.length() - 1));
            int firstLetterPosition = Character.toLowerCase(firstLetter) - 'a' + 1;
            if (Character.isUpperCase(firstLetter)) {
                totalSum += 1.0 * number / firstLetterPosition;
            } else {
                totalSum += 1.0 * number * firstLetterPosition;
            }
            char secondLetter = s.charAt(s.length() - 1);
            int secondLetterPosition = Character.toLowerCase(secondLetter) - 'a' + 1;
            if (Character.isUpperCase(secondLetter)) {
                totalSum -= secondLetterPosition;
            } else {
                totalSum += secondLetterPosition;
            }
        }
        System.out.printf("%.2f", totalSum);
    }
}

