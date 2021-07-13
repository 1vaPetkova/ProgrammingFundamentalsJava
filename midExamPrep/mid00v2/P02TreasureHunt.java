package midExamPrep.mid00v2;

import java.util.*;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> loots = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("Yohoho!")) {
            switch (input.split("\\s+")[0]) {
                case "Loot":
                    List<String> addedItems = Arrays.stream(input.split("\\s+"))
                            .collect(Collectors.toList());
                    for (int i = 1; i < addedItems.size(); i++) {
                        if (!loots.contains(addedItems.get(i))) {
                            loots.add(0, addedItems.get(i));
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    if (index >= 0 && index < loots.size()) {
                        String temp = loots.get(index);
                        loots.remove(index);
                        loots.add(temp);
                    }
                    break;
                case "Steal":
                    List<String> stolen = new ArrayList<>();
                    int count = Math.min(Integer.parseInt(input.split("\\s+")[1]),loots.size());
                    for (int i = 0; i < count; i++) {
                        stolen.add(loots.get(loots.size() - 1));
                        loots.remove(loots.get(loots.size() - 1));
                    }
                    Collections.reverse(stolen);
                    System.out.println(String.join(", ", stolen));
                    break;
            }
        }
        if (!loots.isEmpty()) {
            int sumItemsLength = 0;
            for (String loot : loots) {
                sumItemsLength += loot.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", 1.0 * sumItemsLength / loots.size());
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
