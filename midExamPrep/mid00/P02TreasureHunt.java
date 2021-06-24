package midExamPrep.mid00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> loot = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());
        int initialCount = loot.size();
        String input = "";
        while (!(input = scan.nextLine()).equals("Yohoho!")) {
            List<String> token = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            String command = token.get(0);
            switch (command) {
                case "Loot":
                    for (int i = 1; i < token.size(); i++) {
                        if (!loot.contains(token.get(i))) {
                            loot.add(0, token.get(i));
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(token.get(1));
                    if (index >= 0 && index <= loot.size() - 1) {
                        loot.add(loot.get(index));
                        loot.remove(index);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(token.get(1));
                    List<String> removed = new ArrayList<>();
                    if (count < loot.size()) {
                        for (int i = count; i > 0; i--) {
                            removed.add(loot.get(loot.size() - i));
                            loot.remove(loot.size() - i);
                        }
                        System.out.println(String.join(", ", removed));
                    } else {
                        System.out.println(String.join(", ", loot));
                        loot.clear();
                    }
                    break;
            }
        }
        if(loot.size()!=0){
            int sumItems = 0;
            for (int i = 0; i <loot.size() ; i++) {
                sumItems+=loot.get(i).length();
            }
        double averageGain = (1.0*sumItems/loot.size());
            System.out.printf("Average treasure gain: %.2f pirate credits.",averageGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
