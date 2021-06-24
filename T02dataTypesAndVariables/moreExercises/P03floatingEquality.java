package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P03floatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double aNumber = Double.parseDouble(scan.nextLine());
        double bNumber = Double.parseDouble(scan.nextLine());
        double diff = Math.abs(aNumber - bNumber);

       // int diffMultiplied = (int) (diff * Math.pow(10, 6));

        if (diff > 0.000001) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
