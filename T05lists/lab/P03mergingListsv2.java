package T05lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03mergingListsv2 {
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
        printTheRest(firstList,minSize);
        printTheRest(secondList,minSize);

    }

    private static void printTheRest(List<Integer> numbers, int beginIndex) {

        for (int j = beginIndex; j < numbers.size(); j++) {
            System.out.print(numbers.get(j) + " ");
        }
    }
}
