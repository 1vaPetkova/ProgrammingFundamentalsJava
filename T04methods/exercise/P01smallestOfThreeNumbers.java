package T04methods.exercise;

import java.util.Scanner;

public class P01smallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());
        int result = getTheSmallestNumber(firstNumber, secondNumber, thirdNumber);
        System.out.println(result);
    }

    private static int getTheSmallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        int min1 = Math.min(firstNumber, secondNumber);
        int min = Math.min(min1, thirdNumber);
        return min;
    }
}
