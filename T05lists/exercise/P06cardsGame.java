package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06cardsGame {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> firstHand = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (!firstHand.isEmpty() && !secondHand.isEmpty()) {
            if (firstHand.get(0) > secondHand.get(0)) {
                firstHand.add(firstHand.get(0));
                firstHand.add(secondHand.get(0));
                secondHand.remove(0);
                firstHand.remove(0);
            } else if (firstHand.get(0) < secondHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));
                firstHand.remove(0);
                secondHand.remove(0);
            } else {
                firstHand.remove(0);
                secondHand.remove(0);
            }
        }

        if (!firstHand.isEmpty()) {
            int sum = 0;
            for (int value : firstHand) {
                sum += value;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (int value : secondHand) {
                sum += value;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
