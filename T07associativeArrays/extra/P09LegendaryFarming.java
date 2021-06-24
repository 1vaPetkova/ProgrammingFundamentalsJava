package T07associativeArrays.archive;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class P09LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean isObtained = false;
        while (!isObtained) {
            String[] tokens = scan.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int qty = Integer.parseInt(tokens[i]);
                String item = tokens[i + 1].toLowerCase();
                if (keyMaterials.containsKey(item)) {
                    keyMaterials.put(item, keyMaterials.get(item) + qty);
                    if (keyMaterials.get(item) >= 250) {
                        keyMaterials.put(item, keyMaterials.get(item) - 250);
                        System.out.println(getTheWinner(item) + " obtained!");
                        isObtained = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + qty);
                }
            }
        }
        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junk.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private static String getTheWinner(String item) {
        switch (item) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
        }
        return "";
    }
}
