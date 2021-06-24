package T05lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int capacity = Integer.parseInt(scan.nextLine());
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            List<String> command = Arrays.stream(input.split("\\s+"))
                    .collect(Collectors.toList());
            if (command.get(0).equals("Add")) {
                wagons.add(Integer.parseInt(command.get(1)));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    int currentSum = wagons.get(i) + Integer.parseInt(command.get(0));
                    if (currentSum <= capacity) {
                        wagons.set(i, currentSum);
                        break;
                    }
                }
            }
        }
        for (int value : wagons) {
            System.out.print(value + " ");
        }
    }
}
