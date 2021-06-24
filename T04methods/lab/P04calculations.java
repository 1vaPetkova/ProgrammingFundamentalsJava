package T04methods.lab;

import java.util.Scanner;

public class P04calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String action = scan.nextLine();
        double firstNumber = Double.parseDouble(scan.nextLine());
        double secondNumber = Double.parseDouble(scan.nextLine());

        switch (action) {
            case "add":
                add(firstNumber, secondNumber);
                break;
            case "multiply":
                multiply(firstNumber, secondNumber);
                break;
            case "subtract":
                subtract(firstNumber, secondNumber);
                break;
            case "divide":
                divide(firstNumber, secondNumber);
                break;
        }
    }

    public static void add(double a, double b) {
        double result = a + b;
        System.out.printf("%.0f", result);
    }

    public static void multiply(double a, double b) {
        double result = a * b;
        System.out.printf("%.0f", result);
    }

    public static void subtract(double a, double b) {
        double result = a - b;
        System.out.printf("%.0f", result);
    }


    public static void divide(double a, double b) {
        double result = a / b;
        System.out.printf("%.0f", result);
    }
}

