package T05lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03mergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int minSize = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < minSize; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }
        printTheRest(minSize,firstList,secondList);

    }

    private static void printTheRest(int minSize, List<Integer> firstList, List<Integer> secondList) {
        int maxSize = Math.max(firstList.size(), secondList.size());
        List<Integer> maxList = new ArrayList<>();
        if (minSize == firstList.size()) {
            maxList = secondList;
        } else {
            maxList = firstList;
        }
        for (int j = 0; j < maxSize - minSize; j++) {
            System.out.print(maxList.get(minSize + j) + " ");
        }
    }
}
