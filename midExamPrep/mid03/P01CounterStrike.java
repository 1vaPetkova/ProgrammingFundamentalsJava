package midExamPrep.mid03;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());

        String input = "";
        int wins = 0;
        boolean isOver = false;
        while (!(input = scan.nextLine()).equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (energy >= distance) {
                energy -= distance;
                wins++;
                if (wins%3==0){
                    energy+=wins;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wins, energy);
                isOver = true;
                break;
            }
        }
        if(!isOver){
            System.out.printf("Won battles: %d. Energy left: %d",wins,energy);
        }
    }
}
