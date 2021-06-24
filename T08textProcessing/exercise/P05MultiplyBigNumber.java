package T08textProcessing.exercise;

import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //We need to check whether the first Number starts with zeroes and to remove them;
        String firstNumber = scan.nextLine().replaceFirst("^0+(?!$)", "");
        int secondNumber = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();
        int currResult = 0;

        if (secondNumber == 0 || firstNumber.equals("0")) {
            System.out.println(0);
        } else {
            for (int i = firstNumber.length() - 1; i >= 0; i--) {
                int currDigit = Integer.parseInt(firstNumber.substring(i, i + 1));
                currResult += currDigit * secondNumber;
                result.append(currResult % 10);
                currResult /= 10;
            }
            if (currResult != 0) {
                result.append(currResult);
            }

            System.out.println(result.reverse());
        }
    }
}
