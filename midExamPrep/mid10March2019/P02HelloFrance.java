package midExamPrep.mid10March2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02HelloFrance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] items = scan.nextLine().split("\\|");
        double budget = Double.parseDouble(scan.nextLine());
        List<Double> newPrices = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            String type = items[i].split("->")[0];
            double price = Double.parseDouble(items[i].split("->")[1]);
            switch (type) {
                case "Clothes":
                    if (price <= 50 && budget >= price) {
                        budget -= price;
                        newPrices.add(price * 1.4);
                    }
                    break;
                case "Shoes":
                    if (price <= 35 && budget >= price) {
                        budget -= price;
                        newPrices.add(price * 1.4);
                    }
                    break;
                case "Accessories":
                    if (price <= 20.50 && budget >= price) {
                        budget -= price;
                        newPrices.add(price * 1.4);
                    }
                    break;
            }
        }
        double profit = 0;
        for (Double newPrice : newPrices) {
            System.out.printf("%.2f ", newPrice);
            profit += newPrice;
        }
        System.out.println();
        System.out.printf("Profit: %.2f\n", profit - profit / 1.4);
        if (profit + budget >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}
