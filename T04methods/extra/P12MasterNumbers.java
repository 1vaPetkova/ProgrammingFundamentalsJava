package T04methods.extra;

import java.util.Scanner;

public class P12MasterNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rangeEnd = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= rangeEnd; i++) {
            if (isPalindrome(i) && sumOfDigitsDivisibleBy7(i) && holdsOneEvenDigit(i)) {
                System.out.println(i);
            }
        }
    }


    private static boolean holdsOneEvenDigit(int i) {
        while (i > 0) {
            int lastDigit = i % 10;
            if (lastDigit % 2 == 0) {
                return true;
            }
            i /= 10;
        }
        return false;
    }

    private static boolean sumOfDigitsDivisibleBy7(int i) {
        int sum = 0;
        while (i > 0) {
            int lastDigit = i % 10;
            sum += lastDigit;
            i /= 10;
        }
        if (sum % 7 == 0) {
            return true;
        }
        return false;
    }

    private static boolean isPalindrome(int num) {
        String numberText = String.valueOf(num);
        if (numberText.length() == 1) {
            return true;
        } else {
            boolean isSymmetric = false;
            for (int i = 0; i < numberText.length() / 2; i++) {
                if (numberText.charAt(i) == numberText.charAt(numberText.length() - 1 - i)) {
                    isSymmetric = true;
                } else {
                    return false;
                }
            }
            if (isSymmetric) {
                return true;
            }
        }
        return false;
    }
}
