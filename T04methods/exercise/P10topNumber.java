package T04methods.exercise;

import java.util.Scanner;

public class P10topNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 16; i <= number; i++) {
            if (i == getTopNumberInRange(i)) {
                System.out.println(i);
            }
        }
    }

    private static int getTopNumberInRange(int i) {
        int topInteger = 0;
        int currentNumber = i;
        int lastDigit = 0;
        int sumDigits = 0;
        int countOdd = 0;
        while (currentNumber > 0) {
            lastDigit = currentNumber % 10;
            sumDigits += lastDigit;
            if (lastDigit % 2 != 0) {
                countOdd++;
            }
            currentNumber /= 10;
        }
        if (sumDigits % 8 == 0 && countOdd > 0) {
            topInteger = i;
        }
        return topInteger;
    }
}

