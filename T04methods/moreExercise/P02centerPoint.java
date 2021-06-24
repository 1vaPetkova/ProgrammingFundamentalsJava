package T04methods.moreExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P02centerPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());

        findTheClosestPoint(x1, y1, x2, y2);
    }

    private static void findTheClosestPoint(double x1, double y1, double x2, double y2) {
        double pointOneDistance = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double pointTwoDistance = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
       DecimalFormat df = new DecimalFormat( "#.###########" );
        if (pointOneDistance <= pointTwoDistance) {
            System.out.println("("+df.format(x1)+", "+df.format(y1)+")");
        } else {
            System.out.println("("+df.format(x2)+", "+df.format(y2)+")");
        }
    }
}
