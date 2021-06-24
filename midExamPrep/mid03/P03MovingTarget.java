package midExamPrep.mid03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String[] token = input.split("\\s+");
            int index = Integer.parseInt(token[1]);
            int number = Integer.parseInt(token[2]);
            switch (token[0]) {
                case "Shoot":
                    if (index >= 0 && index < list.size()) {
                        if (list.get(index) - number <= 0) {
                            list.remove(index);
                        } else {
                            list.set(index, list.get(index) - number);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index < list.size()) {
                        list.add(index, number);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index >= 0 && index < list.size()
                            && index - number >= 0 && index + number < list.size()) {
                        if (index + number >= index - number) {
                            list.subList(index - number, index + number + 1).clear();
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
        }
        StringBuilder outputBuilder = new StringBuilder();
        for (Integer integer : list) {
            outputBuilder.append(integer);
            outputBuilder.append("|");
        }
        String output = outputBuilder.toString();

        System.out.println(output.substring(0, output.length() - 1));
    }
}
