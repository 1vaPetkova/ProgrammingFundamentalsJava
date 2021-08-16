package finalExamPrep.archive.RetakeExam10Jan2019PartII;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04SantasNewList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";

        Map<String, Integer> children = new TreeMap<>();
        Map<String, Integer> presents = new LinkedHashMap<>();

        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("->");
            if (!tokens[0].equals("Remove")) {
                String name = tokens[0];
                String present = tokens[1];
                int amount = Integer.parseInt(tokens[2]);
                children.putIfAbsent(name, 0);
                children.put(name, children.get(name) + amount);
                presents.putIfAbsent(present, 0);
                presents.put(present, presents.get(present) + amount);
            } else {
                String childToRemove = tokens[1];
                children.remove(childToRemove);
            }
        }
        System.out.println("Children:");
        children.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(c -> System.out.println(c.getKey() + " -> " + c.getValue()));
        System.out.println("Presents:");
        presents.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
