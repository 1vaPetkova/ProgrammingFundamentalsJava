package T04methods.extra;

import java.util.Scanner;

public class P11GeometryCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figureType = scan.nextLine();
        switch (figureType) {
            case "triangle":
                double side = Double.parseDouble(scan.nextLine());
                double height = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f", findTriangleArea(side, height));
                break;
            case "square":
                double squareSide = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f", findSquareArea(squareSide));
                break;
            case "rectangle":
                double rectangleWidth = Double.parseDouble(scan.nextLine());
                double rectangleHeight = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f", findRectangleArea(rectangleWidth, rectangleHeight));
                break;
            case "circle":
                double radius = Double.parseDouble(scan.nextLine());
                System.out.printf("%.2f", findCircleArea(radius));
                break;
        }
    }

    private static double findCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static double findRectangleArea(double rectangleWidth, double rectangleHeight) {
        return rectangleHeight * rectangleWidth;
    }

    private static double findSquareArea(double squareSide) {
        return squareSide * squareSide;
    }

    private static double findTriangleArea(double side, double height) {
        return side * height / 2;
    }
}
