package T05lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04listManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            List<String> manipulation = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            int currentNumber = Integer.parseInt(manipulation.get(1));
            switch (manipulation.get(0)) {
                case "Add":
                    addNumberToList(numbers, currentNumber);
                    break;
                case "Remove":
                    removeNumberFromList(numbers, currentNumber);
                    break;
                case "RemoveAt":
                    removeNumberAtIndex(numbers, currentNumber);
                    break;
                case "Insert":
                    int index = Integer.parseInt(manipulation.get(2));
                    insertNumberAtIndex(numbers, currentNumber, index);
                    break;
            }
        }
        for (int value : numbers) {
            System.out.print(value + " ");
        }
    }


    private static void insertNumberAtIndex(List<Integer> numbers, int currentNumber, int index) {
        numbers.add(index, currentNumber);
    }

    private static void removeNumberAtIndex(List<Integer> numbers, int currentNumber) {
        numbers.remove(currentNumber);
    }

    private static void removeNumberFromList(List<Integer> numbers, int currentNumber) {
        numbers.remove(Integer.valueOf(currentNumber));
    }

    private static void addNumberToList(List<Integer> numbers, int currentNumber) {
        numbers.add(currentNumber);
    }
}
