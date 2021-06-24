package T05lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08anonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = "";
        String result = "";
        while (!(input = scan.nextLine()).equals("3:1")) {
            List<String> command = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            switch (command.get(0)) {
                case "merge":
                    int startIndex = Integer.parseInt(command.get(1));
                    int endIndex = Integer.parseInt(command.get(2));
                    mergeElementsBetweenIndexes(list, startIndex, endIndex);
                    break;
                case "divide":
                    int index = Integer.parseInt(command.get(1));
                    int partitions = Integer.parseInt(command.get(2));
                    divideElementsbyPartitions(list, index, partitions);
                    break;
            }
        }
        System.out.println(String.join(" ", list));
    }

    private static void divideElementsbyPartitions(List<String> list, int index, int partitions) {
        List<String> currentList = Arrays.stream(list.get(index).split(""))
                .collect(Collectors.toList());
        int length = list.get(index).length() / partitions;
        List<String> newSet = new ArrayList<>();
        if (currentList.size() % partitions == 0) {
            for (int i = 0; i < partitions; i++) {
                String substring = createSubstring(currentList, length);
                newSet.add(substring);
            }
        } else {
            for (int j = 0; j < partitions - 1; j++) {
                String substring = createSubstring(currentList, length);
                newSet.add(substring);
            }
            //adding the last partition of longer elements
            newSet.add(String.join("", currentList));
        }
        //Adding the new List elements at the place next to the index and removing the index element
        for (int k = 0; k < newSet.size(); k++) {
            list.add(index+1+k, newSet.get(k));
        }
        list.remove(index);
    }

    private static String createSubstring(List<String> currentList, int length) {
        StringBuilder divideBuilder = new StringBuilder();
        for (int j = length - 1; j >= 0; j--) {
            divideBuilder.append(currentList.get(j));
            currentList.remove(j);
        }
        return divideBuilder.reverse().toString();
    }

    private static void mergeElementsBetweenIndexes(List<String> list, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > list.size() - 1) {
            endIndex = list.size() - 1;
        }
        StringBuilder mergeBuilder = new StringBuilder();
        if (startIndex < endIndex) {
            for (int i = startIndex; i <= endIndex; i++) {
                mergeBuilder.append(list.get(i));
            }
            list.set(startIndex, mergeBuilder.toString());
            for (int i = endIndex; i >= startIndex + 1; i--) {
                list.remove(i);
            }
        }
    }
}
