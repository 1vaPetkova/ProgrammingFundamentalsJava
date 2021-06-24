package midExamPrep.mid01;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scan.nextLine());
        int[] lift = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean noMoreQueue = false;
        for (int i = 0; i < lift.length; i++) {
            int currentWagon = lift[i];
            if (currentWagon >= 0 && currentWagon < 4) {
                int peopleToFill = 4 - currentWagon;
                if (peopleWaiting >= peopleToFill) {
                    peopleWaiting -= peopleToFill;
                    lift[i] = 4;
                } else {
                    lift[i] = currentWagon + peopleWaiting;
                    peopleWaiting = 0;
                    noMoreQueue = true;
                    break;
                }
            }
        }
        int countPeople = 0;
        for (int i : lift) {
            countPeople += i;
        }
        if (noMoreQueue) {
            System.out.println("The lift has empty spots!");
        } else if (countPeople == lift.length * 4 && peopleWaiting > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleWaiting);
        }
        for (int i : lift) {
            System.out.print(i + " ");
        }
    }
}
