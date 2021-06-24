package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02changeListv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            List<String> command = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            int element = Integer.parseInt(command.get(1));
            switch (command.get(0)) {
                case "Delete":
                    deleteElementsEqualtoNumber(list, element);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command.get(2));
                    insertElementAtPosition(list, element, index);
                    break;
            }
        }
        for (int value : list) {
            System.out.print(value + " ");
        }
    }

    private static void insertElementAtPosition(List<Integer> list, int element, int index) {
        list.add(index, element);
    }

    private static void deleteElementsEqualtoNumber(List<Integer> list, int element) {
        list.removeAll(Arrays.asList(element));
        }
    }

