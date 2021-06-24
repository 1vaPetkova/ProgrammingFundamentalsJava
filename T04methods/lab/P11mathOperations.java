package T04methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11mathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scan.nextLine());
        String operator = scan.nextLine();
        double secondNumber = Double.parseDouble(scan.nextLine());
        double result = operationsResult(firstNumber, operator, secondNumber);
        System.out.println(df.format(result));
    }

    private static double operationsResult(double firstNumber, String operator, double secondNumber) {
        double result = 0;
        switch (operator) {
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                }
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
        }
        return result;
    }
    public static final DecimalFormat df = new DecimalFormat( "#.##" );
}
