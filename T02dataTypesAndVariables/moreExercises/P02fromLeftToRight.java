package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P02fromLeftToRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < lines; i++) {
            String input = scan.nextLine();
            int sumLeftDigits = 0;
            int sumRightDigits = 0;
            //leftSide
            StringBuilder leftBuilder = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                char symbolLeft = input.charAt(j);
                if (symbolLeft == ' ') {
                    break;
                }
                leftBuilder.append(symbolLeft);
                if (symbolLeft >= '0' && symbolLeft <= '9') {
                    int digitLeft = symbolLeft - '0';
                    sumLeftDigits += digitLeft;
                }
            }
            String leftNum = leftBuilder.toString();
            long leftNumber = Long.parseLong(leftNum);
            //rightRide
            StringBuilder rightBuilder = new StringBuilder();
            for (int k = input.length() - 1; k >= 0; k--) {
                char symbolRight = input.charAt(k);
                if (symbolRight == ' ') {
                    break;
                }
                rightBuilder.append(symbolRight);
                if (symbolRight >= '0' && symbolRight <= '9') {
                    int digitRight = symbolRight - '0';
                    sumRightDigits += digitRight;
                }
            }
            rightBuilder.reverse();
            String rightNum = rightBuilder.toString();
            long rightNumber = Long.parseLong(rightNum);
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

