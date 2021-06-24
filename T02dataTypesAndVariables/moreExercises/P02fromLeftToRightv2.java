package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;


public class P02fromLeftToRightv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < lines; i++) {
            String input = scan.nextLine();
            String[] numbers = input.split(" ");
            long leftNumber = Long.parseLong(numbers[0]);
            long rightNumber = Long.parseLong(numbers[1]);
            //SumDigits
            long sumLeftDigits = 0;
            long sumRightDigits = 0;
            long firstNumber = Math.abs(leftNumber);

            while (firstNumber > 0) {
                sumLeftDigits += firstNumber % 10;
                firstNumber /= 10;
            }
            long secondNumber = Math.abs(rightNumber);
            while (secondNumber > 0) {
                sumRightDigits += secondNumber % 10;
                secondNumber /= 10;
            }
            //Finding the maxNumber
            long maxNum = Math.max(leftNumber, rightNumber);
            //Printing the maxSum
            if (maxNum == leftNumber) {
                System.out.println(sumLeftDigits);
            } else {
                System.out.println(sumRightDigits);
            }
        }
    }
}

