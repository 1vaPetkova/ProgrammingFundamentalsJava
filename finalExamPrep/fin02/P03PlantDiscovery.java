package finalExamPrep.fin02;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, Double> rarities = new LinkedHashMap<>();
        Map<String, List<Double>> ratings = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String info = scan.nextLine();
            String plantName = info.split("<->")[0];
            double startRarity = Double.parseDouble(info.split("<->")[1]);
            rarities.putIfAbsent(plantName, 0.0);
            rarities.put(plantName, startRarity);
            ratings.putIfAbsent(plantName, new ArrayList<>());
        }
        String commands = "";
        while (!(commands = scan.nextLine()).equals("Exhibition")) {
            commands = commands.replaceAll("-|:", "");
            String plant = commands.split("\\s+")[1];
            switch (commands.split("\\s+")[0]) {
                case "Rate":
                    if (ratings.containsKey(plant)) {
                        double currentRating = Double.parseDouble(commands.split("\\s+")[2]);
                        ratings.get(plant).add(currentRating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    if (rarities.containsKey(plant)) {
                        double newRarity = Double.parseDouble(commands.split("\\s+")[2]);
                        rarities.put(plant, newRarity);
                    } else{
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (ratings.containsKey(plant)) {
                        ratings.put(plant, new ArrayList<>());
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        Map<String, Double> avgRatings = new TreeMap<>();
        for (Map.Entry<String, List<Double>> entry : ratings.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                double sum = entry.getValue()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .sum();
                avgRatings.putIfAbsent(entry.getKey(), 0.0);
                avgRatings.put(entry.getKey(), sum / entry.getValue().size());
            } else {
                avgRatings.putIfAbsent(entry.getKey(), 0.0);
            }
        }
        System.out.println("Plants for the exhibition:");
        rarities.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()
                .thenComparing((f, s) -> avgRatings.get(s.getKey()).compareTo(avgRatings.get(f.getKey()))))
                .forEach(e -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f\n",
                        e.getKey(), e.getValue(), avgRatings.get(e.getKey())));
    }
}
