package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P10pokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pokePower = Integer.parseInt(scan.nextLine());
        int targetDistance = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());
        int targetsPoked = 0;
        double halfPower = pokePower / 2.0;
        while (pokePower >= targetDistance) {
            pokePower -= targetDistance;
            targetsPoked++;
            if (pokePower == halfPower && exhaustionFactor != 0) {
                pokePower /= exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(targetsPoked);
    }
}
