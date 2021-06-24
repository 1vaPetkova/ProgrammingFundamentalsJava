package T04methods.lab;

import java.util.Scanner;

public class P03printingTrianglev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < height; i++) {
            printSingleLine(1, i);
        }

        for (int i = 0; i < 1; i++) {
            printSingleLine(1, height);
        }
        for (int i = height - 1; i >= 0; i--) {
            printSingleLine(1, i);
        }
    }

    public static void printSingleLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
