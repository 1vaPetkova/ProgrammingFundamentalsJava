package T04methods.extra;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P09LongerLinev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double x3 = Double.parseDouble(scan.nextLine());
        double y3 = Double.parseDouble(scan.nextLine());
        double x4 = Double.parseDouble(scan.nextLine());
        double y4 = Double.parseDouble(scan.nextLine());

        printTheLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }
    private static void printTheLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double firstLineLength = findLineLength(x1,y1,x2,y2);
        double secondLineLength = findLineLength(x3,y3,x4,y4);
        if (firstLineLength >= secondLineLength) {
            printClosestLineFirst(x1,y1,x2,y2);
        } else {
            printClosestLineFirst(x3,y3,x4,y4);
        }
    }

    private static void printClosestLineFirst(double x1, double y1, double x2, double y2) {
        DecimalFormat df = new DecimalFormat( "0.################" );
        if (getDistanceToCenter(x1,y1) <= getDistanceToCenter(x2,y2)) {
            System.out.printf("(%s, %s)(%s, %s)", df.format(x1), df.format(y1), df.format(x2), df.format(y2));
        } else {
            System.out.printf("(%s, %s)(%s, %s)", df.format(x2), df.format(y2), df.format(x1), df.format(y1));
        }
    }

    private static double getDistanceToCenter(double x1, double y1) {
        return Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
    }

    private static double findLineLength(double x1, double y1, double x2, double y2) {
        double xLine = Math.abs(x1 - x2);
        double yLine = Math.abs(y1 - y2);
        return Math.sqrt(Math.pow(xLine, 2) + Math.pow(yLine, 2));
    }
}

