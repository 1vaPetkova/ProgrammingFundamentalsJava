package T07associativeArrays.exercise;

import java.util.*;

public class P09ForceBookv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, TreeSet<String>> users = new LinkedHashMap<>();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] data = input.split("\\s+\\|\\s+");
                String side = data[0];
                String member = data[1];
                users.putIfAbsent(side, new TreeSet<>());
                if (users.entrySet().stream().noneMatch(e ->
                        e.getValue().contains(member))) {
                    users.get(side).add(member);
                }
            } else if (input.contains("->")) {
                String[] data = input.split("\\s+->\\s+");
                String side = data[1];
                String member = data[0];

                users.forEach((key, value) -> value.remove(member));
                users.putIfAbsent(side,new TreeSet<>());
                users.get(side).add(member);
                System.out.println(String.format("%s joins the %s side!", member, side));
            }
            input = scanner.nextLine();
        }
        users.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sorted = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sorted == 0) {
                        sorted = e1.getKey().compareTo(e2.getKey());
                    }
                    return sorted;
                }).forEach(e -> {
            System.out.println(String.format("Side: %s, Members: %d", e.getKey(), e.getValue().size()));
            e.getValue().forEach(u -> {
                System.out.println(String.format("! %s", u));
            });
        });
    }
}
