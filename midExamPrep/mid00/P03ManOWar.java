package midExamPrep.mid00;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxHealthCapacity = Integer.parseInt(scan.nextLine());
        String input = "";
        boolean isOver = false;
        while (!(input = scan.nextLine()).equals("Retire")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int startIndex = 0;
            int endIndex = 0;
            int damage = 0;
            switch (command) {
                case "Fire":
                    startIndex = Integer.parseInt(tokens[1]);
                    damage = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < warShip.size()) {
                        if (warShip.get(startIndex) - damage <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            isOver = true;
                            break;
                        } else {
                            warShip.set(startIndex, warShip.get(startIndex) - damage);
                        }
                    }
                    break;
                case "Defend":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);
                    if (startIndex >= 0 && startIndex < pirateShip.size()
                            && endIndex >= 0 && endIndex < pirateShip.size()
                            && startIndex <= endIndex) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            if (pirateShip.get(i) - damage <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isOver = true;
                                break;
                            } else {
                                pirateShip.set(i, pirateShip.get(i) - damage);
                            }
                        }
                    }
                    break;
                case "Repair":
                    startIndex = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < pirateShip.size()) {
                        if (pirateShip.get(startIndex) + health < maxHealthCapacity) {
                            pirateShip.set(startIndex, pirateShip.get(startIndex) + health);
                        } else {
                            pirateShip.set(startIndex, maxHealthCapacity);
                        }
                    }
                    break;
                case "Status":
                    int countSectionsToRepair = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        if (pirateShip.get(i) < 0.2 * maxHealthCapacity) {
                            countSectionsToRepair++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", countSectionsToRepair);
                    break;
            }
            if (isOver) {///we need to end the while loop as well!
                break;
            }
        }

        if (!isOver) {
            int sumPirateShip = 0;
            for (int health : pirateShip) {
                sumPirateShip += health;
            }
            int sumWarShip = 0;
            for (int health : warShip) {
                sumWarShip += health;
            }
            System.out.printf("Pirate ship status: %d\n", sumPirateShip);
            System.out.printf("Warship status: %d\n", sumWarShip);
        }
    }
}
