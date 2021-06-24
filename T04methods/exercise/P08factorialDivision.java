package T04methods.exercise;

import java.util.Scanner;

public class P08factorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        System.out.printf("%.2f", divideFactorials(firstNumber, secondNumber));
    }

    private static double divideFactorials(int firstNumber, int secondNumber) {
        return getFactorial(firstNumber) / getFactorial(secondNumber);
    }

    private static double getFactorial(int number) {
        double fact = 1;
        do {
            fact *= number;
            number--;
        } while (number > 0);
        return fact;
    }
}
