package T07associativeArrays.moreExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("Season end")) {
            if (input.contains(" -> ")) {
                String playerName = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);
                map.putIfAbsent(playerName, new TreeMap<>());
                map.get(playerName).putIfAbsent(position, 0);
                map.get(playerName).put(position, Math.max(map.get(playerName).get(position), skill));
            } else {
                String firstPlayer = input.split(" vs ")[0];
                String secondPlayer = input.split(" vs ")[1];
                //check if both players exist
                if (map.containsKey(firstPlayer) && map.containsKey(secondPlayer)) {
                    //check for positions in common
                    boolean doPositionsMatch = false;
                    int totalPointsFirst = 0;
                    int totalPointsSecond = 0;
                    for (Map.Entry<String, Integer> firstPositions : map.get(firstPlayer).entrySet()) {
                        for (Map.Entry<String, Integer> secondPositions : map.get(secondPlayer).entrySet()) {
                            if (firstPositions.getKey().equals(secondPositions.getKey())) {
                                totalPointsFirst += firstPositions.getValue();
                                totalPointsSecond += secondPositions.getValue();
                                doPositionsMatch = true;
                            }
                        }
                    }
                    //check who has more total skill points
                    if (doPositionsMatch) {
                        if (totalPointsFirst > totalPointsSecond) {
                            map.remove(secondPlayer);
                        } else if (totalPointsFirst < totalPointsSecond) {
                            map.remove(firstPlayer);
                        }
                    }
                }
            }
        }
        map.entrySet().stream().sorted((f, s) ->
                Integer.compare(s.getValue().values().stream().mapToInt(Integer::intValue).sum(),
                        f.getValue().values().stream().mapToInt(Integer::intValue).sum()))
                .forEach(entry -> {
                    System.out.printf("%s: %d skill\n", entry.getKey(), entry.getValue().values().stream()
                            .mapToInt(Integer::intValue).sum());
                    entry.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(position -> System.out.printf("- %s <::> %d\n", position.getKey(), position.getValue()));
                });
    }
}
