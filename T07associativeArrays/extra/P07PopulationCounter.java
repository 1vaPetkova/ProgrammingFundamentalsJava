package T07associativeArrays.archive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Long>> map = new LinkedHashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("report")) {
            String country = input.split("\\|")[1];
            String city = input.split("\\|")[0];
            long population = Long.parseLong(input.split("\\|")[2]);//each city could have 2 billion population!!! - so LONG!!!
            map.putIfAbsent(country, new LinkedHashMap<>());
            map.get(country).putIfAbsent(city, population);
        }

        map.entrySet().stream().sorted((f, s) ->
                Long.compare(s.getValue().values().stream().mapToLong(Long::longValue).sum(),
                        f.getValue().values().stream().mapToLong(Long::longValue).sum()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)\n", e.getKey(),
                            e.getValue().values().stream().mapToLong(Long::longValue).sum());
                    e.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(position -> System.out.printf("=>%s: %d\n", position.getKey(), position.getValue()));
                });
    }
}
