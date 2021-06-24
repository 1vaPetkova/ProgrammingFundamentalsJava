package T04methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08mathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        double power = Double.parseDouble(scan.nextLine());

        double result = raiseNumberToPower(number,power);
        System.out.println(df1.format(result));
    }

    private static double raiseNumberToPower(double number, double power) {
        return Math.pow(number,power);
    }

    public static final DecimalFormat df1 = new DecimalFormat( "#.####" );

}
