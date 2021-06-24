package T05lists.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05listManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            List<String> manipulation = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            switch (manipulation.get(0)) {
                case "Contains":
                    int number = Integer.parseInt(manipulation.get(1));
                    if (checkIfListContainsNumber(list, number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (manipulation.get(1).equals("even")) {
                        printEvenNumbers(list);
                    } else {
                        printOddNumbers(list);
                    }
                    break;
                case "Get":
                    printSumOfNumbers(list);
                    break;
                case "Filter":
                    int filterNumber = Integer.parseInt(manipulation.get(manipulation.size()-1));
                    String condition = manipulation.get(1);
                    printFilterNumber(list, filterNumber, condition);
                    break;
            }
        }
    }

    private static void printFilterNumber(List<Integer> list, int filterNumber, String condition) {
        switch (condition) {
            case "<":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < filterNumber) {
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;
            case ">":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) > filterNumber) {
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;
            case ">=":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) >= filterNumber) {
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;
            case "<=":
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) <= filterNumber) {
                        System.out.print(list.get(i) + " ");
                    }
                }
                System.out.println();
                break;
        }
    }

    private static void printSumOfNumbers(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }

    private static void printOddNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    private static void printEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    private static boolean checkIfListContainsNumber(List<Integer> list, int number) {
        return list.contains(number);
    }
}
