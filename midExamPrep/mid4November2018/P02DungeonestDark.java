package midExamPrep.mid4November2018;

import java.util.Scanner;

public class P02DungeonestDark {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialHealth = 100;
        int initialCoins = 0;
        int currentHealth = initialHealth;
        int currentCoins = initialCoins;

        boolean isOver = false;
        String[] rooms = scan.nextLine().split("\\|");
        for (int i = 0; i < rooms.length; i++) {
            String itemOrMonster = rooms[i].split("\\s+")[0];
            int number = Integer.parseInt(rooms[i].split("\\s+")[1]);
            switch (itemOrMonster) {
                case "potion":
                    int healthPriorPotion = currentHealth;
                    currentHealth = Math.min(initialHealth, currentHealth + number);
                    int healthAdded = currentHealth - healthPriorPotion;
                    System.out.printf("You healed for %d hp.\n", healthAdded);
                    System.out.printf("Current health: %d hp.\n",currentHealth);
                    break;
                case "chest":
                    currentCoins += number;
                    System.out.printf("You found %d coins.\n", number);
                    break;
                default:
                    currentHealth -= number;
                    if (currentHealth > 0) {
                        System.out.printf("You slayed %s.\n", itemOrMonster);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", itemOrMonster);
                        System.out.printf("Best room: %d",i+1);
                        isOver = true;
                        break;
                    }
                    break;
            }
            if(isOver){
                break;
            }
        }
if(!isOver){
    System.out.println("You've made it!");
    System.out.printf("Coins: %d\n",currentCoins);
    System.out.printf("Health: %s",currentHealth);
}
    }
}
