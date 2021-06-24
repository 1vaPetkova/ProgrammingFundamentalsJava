package T05lists.moreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02carRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double sumTimeLeft = 0;
        double sumTimeRight = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            sumTimeLeft += list.get(i);
            if (list.get(i) == 0) {
                sumTimeLeft *= .8;
            }
        }
        for (int j = list.size() - 1; j > list.size() / 2; j--) {
            sumTimeRight += list.get(j);
            if (list.get(j) == 0) {
                sumTimeRight *= .8;
            }
        }
        if (sumTimeLeft < sumTimeRight) {
            System.out.printf("The winner is left with total time: %.1f", sumTimeLeft);
        } else {
            System.out.printf("The winner is right with total time: %.1f", sumTimeRight);
        }
    }
}

