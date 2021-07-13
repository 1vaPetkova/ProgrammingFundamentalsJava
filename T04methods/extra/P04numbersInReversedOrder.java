package T04methods.extra;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P04NumbersInReversedOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        DecimalFormat df = new DecimalFormat("0.##");
        String numberToString = df.format(number);
        printReversedNumber(number,numberToString);
    }

    private static void printReversedNumber(double number,String numberToString) {
        String[] numberText = numberToString.split("");
        String[] reversedNumber = new String[numberText.length];
        for (int i = 0; i < reversedNumber.length; i++) {
            reversedNumber[i] = numberText[reversedNumber.length - 1 - i];
        }
        System.out.println(String.join("", reversedNumber));
    }
}
