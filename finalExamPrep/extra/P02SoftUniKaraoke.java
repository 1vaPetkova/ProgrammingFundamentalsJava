package finalExamPrep.extra;

import java.util.*;
import java.util.stream.Collectors;

public class P02SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> participants = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        List<String> availableSongs = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        Map<String, List<String>> awards = new TreeMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("dawn")) {
            String[] info = input.split(",\\s+");
            String participant = info[0];
            String song = info[1];
            String award = info[2];
            if (participants.contains(participant) && availableSongs.contains(song)) {
                awards.putIfAbsent(participant, new ArrayList<>());
                if (!awards.get(participant).contains(award)) {
                    awards.get(participant).add(award);
                }
            }
        }
        if (awards.isEmpty()){
                System.out.println("No awards");
        } else {
        awards.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(e -> {
                        System.out.printf("%s: %d awards\n", e.getKey(), e.getValue().size());
                        e.getValue().stream().sorted().forEach(a -> System.out.println("--" + a));
                });
        }
    }
}
