package midExamPrep.demoExamМarch2019;

import java.util.Scanner;

public class P01CookingMasterclass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double flourPrice = Double.parseDouble(scan.nextLine());
        double eggPrice = Double.parseDouble(scan.nextLine());
        double apronPrice = Double.parseDouble(scan.nextLine());
        double sum = 0;
        for (int i = 1; i <= students; i++) {
            sum += (10 * eggPrice + apronPrice);
            if (i % 5 != 0) {
                sum += flourPrice;
            }
        }
        sum += Math.ceil(0.2 * students)*apronPrice;;
        if (budget >= sum) {
            System.out.printf("Items purchased for %.2f$.", sum);
        } else {
            System.out.printf("%.2f$ more needed.", sum - budget);
        }
    }
}
