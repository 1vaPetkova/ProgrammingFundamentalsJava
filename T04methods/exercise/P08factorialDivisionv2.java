package T04methods.exercise;

import java.util.Scanner;

public class P08factorialDivisionv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        System.out.printf("%.2f", divideFactorials(firstNumber, secondNumber));
    }

    private static double divideFactorials(int firstNumber, int secondNumber) {
        return 1.0*getFactorial(firstNumber) / getFactorial(secondNumber);
    }

    private static long getFactorial(int number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
