package midExamPrep.mid4November2018;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03QuestJournal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> journal = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        String input = "";
        while (!(input = scan.nextLine()).equals("Retire!")) {
            switch (input.split("\\s+-\\s+")[0]) {
                case "Start":
                    String questToAdd = input.split("\\s+-\\s+")[1];
                    if (!journal.contains(questToAdd)) {
                        journal.add(questToAdd);
                    }
                    break;
                case "Complete":
                    String questToRemove = input.split("\\s+-\\s+")[1];
                    journal.remove(questToRemove);
                    break;
                case "Side Quest":
                    String currentQuest = input.split("\\s+-\\s+")[1].split(":")[0];
                    String sideQuest = input.split("\\s+-\\s+")[1].split(":")[1];
                    if (journal.contains(currentQuest) && !journal.contains(sideQuest)) {
                        journal.add(journal.indexOf(currentQuest) + 1, sideQuest);
                    }
                    break;
                case "Renew":
                    String questToRenew = input.split("\\s+-\\s+")[1];
                    if (journal.contains(questToRenew)) {
                        String temp = questToRenew;
                        journal.remove(questToRenew);
                        journal.add(temp);
                    }
                    break;
            }
        }
        System.out.println(String.join(", ", journal));
    }
}
