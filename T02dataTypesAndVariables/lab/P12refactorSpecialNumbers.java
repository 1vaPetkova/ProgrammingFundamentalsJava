package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P12refactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        boolean isSpecial = false;
        for (int i = 1; i <= number; i++) {
            int sum = 0;
            int currentNum = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", currentNum);
            } else {
                System.out.printf("%d -> False%n", currentNum);
            }
            i = currentNum;
        }
    }
}
