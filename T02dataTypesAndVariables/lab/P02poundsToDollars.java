package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P02poundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double pounds = Double.parseDouble(scan.nextLine());
        double dollars = 1.31*pounds;
        System.out.printf("%.3f",dollars);
    }
}
