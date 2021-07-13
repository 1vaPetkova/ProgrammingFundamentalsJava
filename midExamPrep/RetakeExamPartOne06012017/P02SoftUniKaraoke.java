package midExamPrep.RetakeExamPartOne06012017;

import java.util.*;
import java.util.stream.Collectors;

public class P02SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> participants = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        List<String> songs = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        Map<String, List<String>> awards = new TreeMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("dawn")) {
            String participant = input.split(",\\s+")[0];
            String song = input.split(",\\s+")[1];
            String award = input.split(",\\s+")[2];

            if (participants.contains(participant) && songs.contains(song)) {
                awards.putIfAbsent(participant, new ArrayList<>());
                if (awards.containsKey(participant) && !awards.get(participant).contains(award)) {
                    awards.get(participant).add(award);
                }
            }
        }
        if (awards.isEmpty()) {
            System.out.println("No awards");
        } else {
            awards.entrySet().stream().sorted((f, s) ->
                    Integer.compare(s.getValue().size(), f.getValue().size())).forEach(e -> {
                System.out.printf("%s: %d awards\n", e.getKey(), e.getValue().size());
                e.getValue().forEach(award -> System.out.println("--" + award));
            });
        }
    }
}

