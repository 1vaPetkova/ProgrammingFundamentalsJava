package midExamPrep.mid03;

import java.util.Scanner;

public class P01CounterStrikev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        String input = "";
        int count = 0;
        boolean isOver = false;
        while (!(input = scan.nextLine()).equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (energy >= distance) {
                energy -= distance;
                count++;
            } else {
                isOver = true;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",
                        count, energy);
                break;
            }
            if (count % 3 == 0) {
                energy += count;
            }
        }
        if (!isOver) {
            System.out.printf("Won battles: %d. Energy left: %d", count, energy);
        }
    }
}
