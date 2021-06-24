package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09kaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());

        int bestStartIndex = length-1;
        int bestDNASum = 0;
        int bestLength = 0;
        int countRows = 0;
        int bestDNARow = 0;
        int[] bestDNA = new int[length];

        String input = scan.nextLine();
        while (!input.equals("Clone them!")) {
            countRows++;
            int[] currentDNA = Arrays.stream(input.split("!+"))//we can have one or more !!
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int currentDNASum = 0;
            int currentStart = -1;
            int currentLength = 0;
            int currentStartIndex = -1;
            int currentMaxLength = 0;

            //Finding the max length in the currentDNA
            for (int i = 0; i < currentDNA.length; i++) {
                if (currentDNA[i] == 1) {
                    if (currentStart == -1) {
                        currentStart = i;
                    }
                    currentDNASum++;
                    currentLength++;
                }
                if (currentDNA[i] == 0 || i == currentDNA.length - 1) {
                    if (currentLength > currentMaxLength) {
                        currentMaxLength = currentLength;
                        currentStartIndex = currentStart;
                    }
                    currentLength=0;
                    currentStart=-1;
                }
            }
            //Finding the row with the max sequence of 1
            boolean isCurrentDNABetter = false;

            if (currentMaxLength > bestLength) {
                isCurrentDNABetter = true;
            }
                //If there are more than one rows with the max sequence of 1
                //Print the one with the leftmost start index
            if (currentMaxLength == bestLength && currentStartIndex < bestStartIndex) {
                    isCurrentDNABetter = true;
                }
                    //Print the one with the biggest sum of elements
            if (currentMaxLength == bestLength && currentStartIndex == bestStartIndex && currentDNASum > bestDNASum) {
                        isCurrentDNABetter = true;
                    }
            if (isCurrentDNABetter) {
                bestLength = currentMaxLength;
                bestDNA = currentDNA;
                bestDNARow = countRows;
                bestDNASum = currentDNASum;
                bestStartIndex = currentStartIndex;
            }
            input = scan.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNARow, bestDNASum);
        for (int value : bestDNA) {
            System.out.print(value + " ");
        }
    }
}