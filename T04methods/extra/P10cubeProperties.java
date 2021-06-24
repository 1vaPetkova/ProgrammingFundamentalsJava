package T04methods.еxerciseЕlena;

import java.util.Scanner;

public class P10cubeProperties {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double side = Double.parseDouble(scan.nextLine());
        String parameter = scan.nextLine();

        System.out.printf("%.2f", getCubeParameter(side, parameter));
    }

    private static double getCubeParameter(double side, String parameter) {
        switch (parameter) {
            case "face":
                return findCubeFaceDiagonal(side);
            case "space":
                return findCubeSpaceDiagonal(side);
            case "volume":
                return findCubeVolume(side);
        }
        return findCubeSurfaceArea(side);
    }

    private static double findCubeSurfaceArea(double side) {
        return 6 * side * side;
    }

    private static double findCubeVolume(double side) {
        return Math.pow(side, 3);
    }

    private static double findCubeSpaceDiagonal(double side) {
        return Math.sqrt(3) * side;
    }

    private static double findCubeFaceDiagonal(double side) {
        return Math.sqrt(2) * side;
    }
}
