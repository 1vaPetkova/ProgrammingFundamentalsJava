package T07associativeArrays.exercise;

import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, List<String>> map = new TreeMap<>();
        while (!(input = scan.nextLine()).equals("Lumpawaroo")) {
            String[] tokens = input.split("\\s+\\|\\s+|\\s+->\\s+");
            if (input.contains(" | ")) {
                String side = tokens[0];
                String user = tokens[1];
                map.putIfAbsent(side, new ArrayList<>());
                //We need to check whether we have the user in the whole map!!!
                if (map.entrySet().stream().noneMatch(e ->
                        e.getValue().contains(user))) {
                    map.get(side).add(user);
                }
            } else {
                String side = tokens[1];
                String user = tokens[0];
                map.forEach((k, v) -> v.remove(user));
                map.putIfAbsent(side, new ArrayList<>());
                map.get(side).add(user);
                System.out.printf("%s joins the %s side!\n", user, side);
            }
        }
            map.entrySet().stream()
                    .filter(l -> l.getValue().size() > 0)
                    .sorted((f, s) -> {
                        int result = Integer.compare(s.getValue().size(), f.getValue().size());
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    })
                    .forEach(e -> {
                        System.out.printf("Side: %s, Members: %d\n", e.getKey(), e.getValue().size());
                        e.getValue().stream().sorted(String::compareTo)
                                .forEach(members -> System.out.println("! " + members));
                    });
        }
    }


