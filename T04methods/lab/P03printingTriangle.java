package T04methods.lab;

import java.util.Scanner;

public class P03printingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = Integer.parseInt(scan.nextLine());
        printTriangle(height);
    }

    public static void printTriangle(int height) {
        printTopHalf(height);
        printBottomHalf(height);
    }

    public static void printTopHalf(int height) {
        for (int i = 1; i <= height; i++) {
            printSingleLine(i);
        }
    }

    public static void printBottomHalf(int height) {
        for (int i = height-1; i > 0; i--) {
            printSingleLine(i);
        }
    }

    public static void printSingleLine(int length) {
        for (int i = 1; i <=length ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
