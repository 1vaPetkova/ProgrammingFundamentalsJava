package midExamPrep.demoExamМarch2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03CookingFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        int bestSum = 0;
        double bestAverage = 0;

        List<Integer> bestBatch = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("Bake It!")) {
            List<Integer> list = Arrays.stream(input.split("#"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (list.size() > 10) {
                break;
            }
            int currentSum = list.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            double currentAverage = 1.0 * currentSum / list.size();

            if (currentSum > bestSum) {
                bestSum = currentSum;
                bestBatch = list;
            } else if (currentSum == bestSum) {
                if (currentAverage > bestAverage) {
                    bestAverage = currentAverage;
                    bestBatch = list;
                } else if (currentAverage == bestAverage) {
                    if (list.size() < bestBatch.size()) {
                        bestAverage = currentAverage;
                        bestBatch = list;
                    }
                }
            }
        }
        System.out.printf("Best Batch quality: %d\n", bestSum);
        for (Integer bread : bestBatch) {
            System.out.print(bread + " ");
        }
    }
}
