package T07associativeArrays.archive;

import java.security.spec.ECField;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("End")) {
            String singer = input.split("@")[0];
            if (singer.charAt(singer.length() - 1) != ' ') {
                continue;
            }
            singer = singer.trim();
            String[] venuePrices = input.split("@")[1].split(" ");
            if (venuePrices.length < 3) {
                continue;
            }
            int ticketCount = 0;
            int ticketPrice = 0;
            try {
                ticketCount = Integer.parseInt(venuePrices[venuePrices.length - 1]);
                ticketPrice = Integer.parseInt(venuePrices[venuePrices.length - 2]);
            } catch (Exception e) {
                continue;
            }
            String currVenue = "";
            for (int i = 0; i < venuePrices.length - 2; i++) {
                currVenue += venuePrices[i] + " ";
            }
            currVenue = currVenue.trim();

            venues.putIfAbsent(currVenue, new LinkedHashMap<>());
            venues.get(currVenue).putIfAbsent(singer, 0);
            venues.get(currVenue).put(singer, venues.get(currVenue).get(singer) + ticketCount * ticketPrice);
        }
        venues.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(singer -> System.out.printf("#  %s -> %d\n", singer.getKey(), singer.getValue()));
        });
    }
}
