package midExamPrep.mid00v2;

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
        int maxHealth = Integer.parseInt(scan.nextLine());
        String input = "";
        boolean isOver = false;
        while (!(input = scan.nextLine()).equals("Retire")) {
            switch (input.split("\\s+")[0]) {
                case "Fire":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    int warshipDamage = Integer.parseInt(input.split("\\s+")[2]);
                    if (isValid(index, warShip)) {
                        warShip.set(index, warShip.get(index) - warshipDamage);
                    if (warShip.get(index) <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        isOver = true;
                        break;
                    }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int endIndex = Integer.parseInt(input.split("\\s+")[2]);
                    int pirateDamage = Integer.parseInt(input.split("\\s+")[3]);
                    if (isValid(startIndex, pirateShip) && isValid(endIndex, pirateShip)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip.set(i, pirateShip.get(i) - pirateDamage);
                            if (pirateShip.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isOver = true;
                                break;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int health = Integer.parseInt(input.split("\\s+")[2]);
                    if (isValid(repairIndex, pirateShip)) {
                        pirateShip.set(repairIndex, Math.min(maxHealth, pirateShip.get(repairIndex) + health));
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (Integer currHealth : pirateShip) {
                        if (currHealth < 0.2 * maxHealth) {
                            count++;
                        }
                    }
                    System.out.println(count + " sections need repair.");
                    break;
            }
            if (isOver) {
                break;
            }
        }
        if (!isOver) {
            int sumPirateShip = pirateShip.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Pirate ship status: %d\n", sumPirateShip);
            int sumWarship = warShip.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Warship status: %d\n", sumWarship);
        }
    }

    private static boolean isValid(int index, List<Integer> ship) {
        return index >= 0 && index < ship.size();
    }
}
