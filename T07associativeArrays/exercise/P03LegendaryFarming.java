package T07associativeArrays.exercise;



import java.util.*;


public class P03LegendaryFarming {
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
                        String winner = "";
                        switch (item) {
                            case "shards":
                                winner = "Shadowmourne";
                                break;
                            case "fragments":
                                winner = "Valanyr";
                                break;
                            case "motes":
                                winner = "Dragonwrath";
                                break;
                        }
                        System.out.println(winner + " obtained!");
                        isObtained = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(item, 0);
                    junk.put(item, junk.get(item) + qty);
                }
            }
        }
        keyMaterials.entrySet().
                stream().
                sorted((f, s) ->
                {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junk.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
