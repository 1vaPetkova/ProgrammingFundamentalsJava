package midExamPrep.midRetake18December2018;

import java.util.Scanner;

public class P01ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = Integer.parseInt(scan.nextLine());
        int daysUntilChristmas = Integer.parseInt(scan.nextLine());
        int ornamentSetPrice = 2;
        int treeSkirtPrice = 5;
        int treeGarlandsPrice = 3;
        int treeLightsPrice = 15;

        int currentDay = 0;
        int totalSpirit = 0;
        int totalCost = 0;

        while (daysUntilChristmas - currentDay != 0) {
            currentDay++;
            if (currentDay % 2 == 0) {
                totalCost += ornamentSetPrice * quantity;
                totalSpirit += 5;
            }
            if (currentDay % 3 == 0) {
                totalCost += (treeSkirtPrice + treeGarlandsPrice) * quantity;
                totalSpirit += 13;
            }
            if (currentDay % 5 == 0) {
                totalCost += (treeLightsPrice) * quantity;
                totalSpirit += 17;
            }
            if (currentDay % 15 == 0) {
                totalSpirit += 30;
            }

            if (currentDay % 10 == 0) {
                totalSpirit -= 20;
                totalCost += treeSkirtPrice + treeGarlandsPrice + treeLightsPrice;
                quantity += 2;
            }
        }
        if (daysUntilChristmas % 10 == 0) {
            totalSpirit -= 30;
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("Total spirit: " + totalSpirit);
    }
}
