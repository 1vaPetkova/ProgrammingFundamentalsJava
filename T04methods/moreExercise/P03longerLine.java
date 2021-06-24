package T04methods.moreExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P03longerLine {
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

        findTheLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private static void findTheLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double pointOneDistance = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double pointTwoDistance = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        double pointThreeDistance = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2));
        double pointFourDistance = Math.sqrt(Math.pow(x4, 2) + Math.pow(y4, 2));
        double xFirstLine = Math.abs(x1 - x2);
        double yFirstLine = Math.abs(y1 - y2);
        double firstLineLength = Math.sqrt(Math.pow(xFirstLine, 2) + Math.pow(yFirstLine, 2));
        double xSecondLine = Math.abs(x3 - x4);
        double ySecondLine = Math.abs(y3 - y4);
        double secondLineLength = Math.sqrt(Math.pow(xSecondLine, 2) + Math.pow(ySecondLine, 2));

        DecimalFormat df = new DecimalFormat( "0.##############################################" );
        if (firstLineLength >= secondLineLength) {
            if (pointOneDistance < pointTwoDistance) {
                System.out.printf("(%s, %s)(%s, %s)", df.format(x1), df.format(y1), df.format(x2), df.format(y2));
            } else {
                System.out.printf("(%s, %s)(%s, %s)", df.format(x2), df.format(y2), df.format(x1), df.format(y1));
            }
        } else {
            if (pointThreeDistance < pointFourDistance) {
                System.out.printf("(%s, %s)(%s, %s)", df.format(x3), df.format(y3), df.format(x4), df.format(y4));
            } else {
                System.out.printf("(%s, %s)(%s, %s)", df.format(x4), df.format(y4), df.format(x3), df.format(y3));
            }
        }
    }
}

