package midExamPrep.demoExamМarch2019;

import java.util.Scanner;

public class P02BreadFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialEnergy = 100;
        int initialCoins = 100;
        int currentEnergy = initialEnergy;
        int currentCoins = initialCoins;
        boolean isOver = false;
        String[] events = scan.nextLine().split("\\|");
        for (int i = 0; i < events.length; i++) {
            int number = Integer.parseInt(events[i].split("-")[1]);
            switch (events[i].split("-")[0]) {
                case "rest":
                    int temp = currentEnergy;
                    currentEnergy = Math.min(initialEnergy, currentEnergy + number);
                    System.out.printf("You gained %d energy.\n", currentEnergy - temp);
                    System.out.printf("Current energy: %d.\n", currentEnergy);
                    break;
                case "order":
                    if (currentEnergy >= 30) {
                        currentEnergy -= 30;
                        currentCoins += number;
                        System.out.printf("You earned %d coins.\n", number);
                    } else {
                        currentEnergy += 50;
                        System.out.println("You had to rest!");
                    }
                    break;
                default:
                    if (currentCoins > number) {
                        currentCoins -= number;
                        System.out.printf("You bought %s.\n", events[i].split("-")[0]);
                    } else {
                        System.out.printf("Closed! Cannot afford %s.\n", events[i].split("-")[0]);
                        isOver = true;
                        break;
                    }
                    break;
            }
            if (isOver) {
                break;
            }
        }
        if (!isOver) {
            System.out.println("Day completed!");
            System.out.printf("Coins: %d\n", currentCoins);
            System.out.printf("Energy: %d\n", currentEnergy);
        }
    }
}
