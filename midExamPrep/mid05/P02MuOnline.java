package midExamPrep.Е05;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rooms = scan.nextLine().split("\\|");
        int initialHealth = 100;
        int currentHealth = initialHealth;
        int bitcoins = 0;
        boolean isOver = false;
        for (int i = 0; i < rooms.length; i++) {
            String[] input = rooms[i].split(" ");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            switch (command) {
                case "potion":
                    if (currentHealth + number <= initialHealth) {
                        currentHealth += number;
                    } else {
                        number = initialHealth-currentHealth;
                        currentHealth=initialHealth;
                    }
                        System.out.printf("You healed for %d hp.\n", number);
                        System.out.printf("Current health: %d hp.\n", currentHealth);
                    break;
                case "chest":
                    bitcoins += number;
                    System.out.printf("You found %d bitcoins.\n", number);
                    break;
                default:
                    currentHealth -= number;
                    if (currentHealth > 0) {
                        System.out.printf("You slayed %s.\n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", command);
                        System.out.printf("Best room: %d\n", i + 1);
                        isOver = true;
                    }
                    break;
            }
            if (isOver) {
                break;
            }
        }
        if (!isOver) {
            System.out.printf("You've made it!\nBitcoins: %d\nHealth: %d", bitcoins, currentHealth);
        }
    }
}
