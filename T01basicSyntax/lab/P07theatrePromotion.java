package T01basicSyntax.lab;

import java.util.Scanner;

public class P07theatrePromotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int price = 0;

        boolean error = false;
        if (day.equals("Weekday")) {
            if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                price = 12;
            } else if (age > 18 && age <= 64) {
                price = 18;
            } else {
                error = true;
            }
        } else if (day.equals("Weekend")) {
            if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                price = 15;
            } else if (age > 18 && age <= 64) {
                price = 20;
            } else {
                error = true;
            }
        } else if (day.equals("Holiday")) {
            if (age >= 0 && age <= 18) {
                price = 5;
            } else if (age > 18 && age <= 64) {
                price = 12;
            } else if (age > 64 && age <= 122) {
                price = 10;
            } else {
                error = true;
            }
        } else {
            error = true;
        }
        if (error) {
            System.out.println("Error!");
        } else {
            System.out.println(price + "$");
        }
    }
}

