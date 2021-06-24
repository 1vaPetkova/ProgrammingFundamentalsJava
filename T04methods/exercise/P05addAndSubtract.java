package T04methods.exercise;

import java.util.Scanner;

public class P05addAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());

        int result = subtractTheSum(firstNumber, secondNumber, thirdNumber);
        System.out.println(result);
    }

    private static int subtractTheSum(int firstNumber, int secondNumber, int thirdNumber) {
        return sumOfTwoNumbers(firstNumber, secondNumber)-thirdNumber;
    }

    private static int sumOfTwoNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
