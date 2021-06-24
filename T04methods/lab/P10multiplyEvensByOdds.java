package T04methods.lab;

import java.util.Scanner;

public class P10multiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int result = multiplySumEvenbySumOdd(Math.abs(number));
        System.out.println(result);
    }

    private static int multiplySumEvenbySumOdd(int number) {
        int sumEvenDigits = getSumEven(number);
        int sumOddDigits = getSumOdd(number);
        return sumEvenDigits * sumOddDigits;
    }


    private static int getSumEven(int number) {
        int sumEvenDigits = 0;
        int lastDigit = 0;
        int countdigits = 0;
        while (number > 0) {
            lastDigit =number % 10;
            countdigits++;
            if (lastDigit % 2 == 0) {
                sumEvenDigits += lastDigit;
            }
            number = number / 10;
        }
        return sumEvenDigits;
    }

    private static int getSumOdd(int number) {
        int sumOddDigits = 0;
        int lastDigit = 0;
        while (number > 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                sumOddDigits += lastDigit;
            }
            number = number / 10;
        }
        return sumOddDigits;
    }
}
