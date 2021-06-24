package T08textProcessing.exercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String first = input.split(" ")[0];
        String second = input.split(" ")[1];
        int totalSum = 0;
        int minLength = Math.min(first.length(), second.length());
        for (int i = 0; i < minLength; i++) {
            totalSum += first.charAt(i) * second.charAt(i);
        }
        if (first.length() == minLength) {
            for (int i = minLength; i < second.length(); i++) {
                totalSum += second.charAt(i);
            }
        } else {
            for (int i = minLength; i < first.length(); i++) {
                totalSum += first.charAt(i);
            }
        }
        System.out.println(totalSum);
    }
}
