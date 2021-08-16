package finalExamPrep.extra;

import java.util.*;
import java.util.function.Predicate;

public class P04MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        List<Player> players = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("Season end")) {
            if (!input.contains("vs")) {
                String[] tokens = input.split(" -> ");
                String name = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);
                Predicate<Player> findPlayer = p -> p.getName().equals(name);
                if (players.stream().noneMatch(findPlayer)) {
                    Player player = new Player(name);
                    player.getPositions().putIfAbsent(position, 0);
                    player.getPositions().put(position, Math.max(player.getPositions().get(position), skill));
                    players.add(player);
                } else {
                    players.stream().filter(findPlayer).findFirst().ifPresent(e -> {
                        e.getPositions().putIfAbsent(position, 0);
                        e.getPositions().put(position, Math.max(e.getPositions().get(position), skill));
                    });
                }
            } else {
                String firstPlayer = input.split(" vs ")[0];
                String secondPlayer = input.split(" vs ")[1];
                if (players.stream().anyMatch(p -> p.getName().equals(firstPlayer)) &&
                        players.stream().anyMatch(p -> p.getName().equals(secondPlayer))) {
                    Player first = players.stream().filter(p -> p.getName().equals(firstPlayer)).findFirst().get();
                    Player second = players.stream().filter(p -> p.getName().equals(secondPlayer)).findFirst().get();
                    Set<String> keys = new HashSet<>(first.getPositions().keySet());
                    keys.retainAll(second.getPositions().keySet());
                    if (!keys.isEmpty()) {
                        if (first.getTotalSkills() > second.getTotalSkills()) {
                            players.remove(second);
                        } else if (second.getTotalSkills() > first.getTotalSkills()) {
                            players.remove(first);
                        }
                    }
                }
            }
        }

        players.stream().sorted((f, s) -> {
                    int result = Integer.compare(s.getTotalSkills(), f.getTotalSkills());
                    if (result == 0) {
                        result = f.getName().compareTo(s.getName());
                    }
                    return result;
                })
                .forEach(p -> {
                    System.out.printf("%s: %d skill\n", p.getName(), p.getTotalSkills());
                    p.getPositions().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                            .forEach(e -> System.out.printf("- %s <::> %d\n", e.getKey(), e.getValue()));
                });
    }

    public static class Player {
        private String name;
        private HashMap<String, Integer> positions;


        public Player(String name) {
            this.name = name;
            this.positions = new HashMap<>();
        }

        public int getTotalSkills() {
            return this.positions.values().stream().mapToInt(i -> i).sum();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, Integer> getPositions() {
            return positions;
        }
    }
}
