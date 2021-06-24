package T04methods.lab;

import java.util.Scanner;

public class P02grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printGradeName(Double.parseDouble(scan.nextLine()));
    }

    private static void printGradeName(double grade) {
        String gradeName = "";
        if (grade >= 2.00 && grade <= 2.99) {
            gradeName = "Fail";
        } else if (grade <= 3.49) {
            gradeName = "Poor";
        } else if (grade <= 4.49) {
            gradeName = "Good";
        } else if (grade <= 5.49) {
            gradeName = "Very good";
        } else if (grade <= 6.00) {
            gradeName = "Excellent";
        }
        System.out.println(gradeName);
    }
}
