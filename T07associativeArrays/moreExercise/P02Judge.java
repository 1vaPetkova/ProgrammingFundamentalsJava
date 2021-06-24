package T07associativeArrays.moreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P02Judge {
    public static int count = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        Map<String, Integer> individual = new TreeMap<>();
        while (!(input = scan.nextLine()).equals("no more time")) {
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);
            map.putIfAbsent(contest, new TreeMap<>());
            map.get(contest).putIfAbsent(username, 0);
            map.get(contest).put(username, Math.max(map.get(contest).get(username), points));
        }

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            for (Map.Entry<String, Integer> points : entry.getValue().entrySet()) {
                individual.putIfAbsent(points.getKey(), 0);
                individual.put(points.getKey(), individual.get(points.getKey()) + points.getValue());
            }
        }

        map.entrySet().stream().
                forEach(e -> {
                    System.out.printf("%s: %d participants\n", e.getKey(), e.getValue().size());
                    e.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            //.thenComparing(Map.Entry.comparingByKey()))
                            .forEach(user -> {
                                System.out.printf("%d. %s <::> %d\n", count, user.getKey(), user.getValue());
                                count++;
                            });
                    count = 1;
                });
        System.out.println("Individual standings:");
        individual.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(user -> {
                    System.out.printf("%d. %s -> %d\n", count, user.getKey(), user.getValue());
                    count++;
                });
    }
}

