package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04listOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            List<String> command = Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.toList());
            switch (command.get(0)) {
                case "Add":
                    int numberToAdd = Integer.parseInt(command.get(1));
                    addNumberToList(list, numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(command.get(1));
                    int indexToInsert = Integer.parseInt(command.get(2));
                    insertNumberAtIndex(list, numberToInsert, indexToInsert);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(command.get(1));
                    removeNumberFromList(list, indexToRemove);
                    break;
                case "Shift":
                    int countToShift = Integer.parseInt(command.get(2));
                    shiftNumbers(command, list, countToShift);
                    break;
            }
        }
        for (int value : list) {
            System.out.print(value + " ");
        }

    }

    private static void shiftNumbers(List<String> command, List<Integer> list, int countToShift) {
        if (command.get(1).equals("left")) {
            shiftLeftNumbers(list, countToShift);
        } else {
            shiftRightNumbers(list, countToShift);
        }
    }

    private static void shiftRightNumbers(List<Integer> list, int countToShift) {
        for (int i = 0; i < countToShift; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size()-1);
        }
    }

    private static void shiftLeftNumbers(List<Integer> list, int countToShift) {
        for (int i = 0; i < countToShift; i++) {
            list.add(list.get(0));
            list.remove(0);
        }
    }

    private static void removeNumberFromList(List<Integer> list, int indexToRemove) {
        if (indexToRemove>=0&&indexToRemove < list.size()) {
            list.remove(indexToRemove);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void insertNumberAtIndex(List<Integer> list, int numberToInsert, int indexToInsert) {
        if (indexToInsert>=0&&indexToInsert < list.size()) {
            list.add(indexToInsert, numberToInsert);
        } else {
            System.out.println("Invalid index");
        }
    }

    private static void addNumberToList(List<Integer> list, int numberToAdd) {
        list.add(numberToAdd);
    }
}
