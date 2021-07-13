package midExamPrep.mid01v2;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int waitingPeople = Integer.parseInt(scan.nextLine());
        int[] wagons = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleOnTheLift = 0;
        for (int i = 0; i < wagons.length; i++) {
            int freeSpace = 4 - wagons[i];
            if (waitingPeople >= freeSpace) {
                wagons[i] = 4;
                waitingPeople -= freeSpace;
                peopleOnTheLift += wagons[i];
            } else {
                wagons[i] += waitingPeople;
                peopleOnTheLift += wagons[i];
                waitingPeople = 0;
                break;
            }
        }
        if (waitingPeople == 0 && peopleOnTheLift < wagons.length * 4) {
            System.out.println("The lift has empty spots!");
        } else if (waitingPeople > 0 && peopleOnTheLift == wagons.length * 4) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", waitingPeople);
        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
