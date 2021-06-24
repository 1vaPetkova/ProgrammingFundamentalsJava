package midExamPrep.mid05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String item = tokens[1];
            switch (command) {
                case "Collect":
                    if (!list.contains(item)) {
                        list.add(item);
                    }
                    break;
                case "Drop":
                    list.remove(item);
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (list.contains(oldItem)) {
                        int oldIndex = list.indexOf(oldItem);
                        list.add(oldIndex + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (list.contains(item)) {
                        int index = list.indexOf(item);
                        list.add(item);
                        list.remove(index);
                    }
                    break;
            }
        }
        System.out.println(String.join(", ", list));
    }
}
