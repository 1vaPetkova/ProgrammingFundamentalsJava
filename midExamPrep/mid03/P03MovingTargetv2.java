package midExamPrep.mid03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTargetv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            int index = Integer.parseInt(input.split("\\s+")[1]);
            int value = Integer.parseInt(input.split("\\s+")[2]);
            switch (input.split("\\s+")[0]) {
                case "Shoot":
                    if (isValid(index, list)) {
                        list.set(index, list.get(index) - value);
                        if (list.get(index) <= 0) {
                            list.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (isValid(index, list)) {
                        list.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int minIndex = index - value;
                    int maxIndex = index + value;
                    if (isValid(minIndex, list) && isValid(maxIndex, list)) {
                        for (int i = maxIndex; i >= minIndex; i--) {
                            list.remove(list.get(i));
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
        }
        StringBuilder output = new StringBuilder();
        for (Integer value : list) {
            output.append(value).append("|");
        }
        System.out.println(output.substring(0, output.length() - 1));
    }

    private static boolean isValid(int index, List<Integer> values) {
        return index >= 0 && index < values.size();
    }
}
