package T04methods.lab;

import java.util.Scanner;

public class P06calculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double width = Integer.parseInt(scan.nextLine());
        double length = Integer.parseInt(scan.nextLine());
        double area = calculateArea(width, length);
        System.out.printf("%.0f", area);
    }

    private static double calculateArea(double width, double length) {
        return width * length;
    }
}
