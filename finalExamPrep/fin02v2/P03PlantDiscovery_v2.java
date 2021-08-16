package finalExamPrep.fin02v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class P03PlantDiscovery_v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<Plant> plants = new ArrayList<>();
        while (lines-- > 0) {
            String[] info = scan.nextLine().split("<->");
            String plantName = info[0];
            Plant plant = new Plant(plantName);
            int rarity = Integer.parseInt(info[1]);
            if (plants.contains(plant)) {
                plants.stream().filter(p -> p.equals(plant)).findFirst().ifPresent(p -> p.setRarity(rarity));
            } else {
                plants.add(new Plant(plantName, rarity));
            }
        }

        String input = "";
        while (!(input = scan.nextLine()).equals("Exhibition")) {
            String[] tokens = input.split(": ");
            String[] pairs = tokens[1].split(" - ");
            String currentPlant = pairs[0];
            Predicate<Plant> findPlant = p -> p.getName().equals(currentPlant);
            switch (tokens[0]) {
                case "Rate":
                    double rating = Double.parseDouble(pairs[1]);
                    if (plants.stream().anyMatch(findPlant)) {
                        plants.stream().filter(findPlant).findFirst().ifPresent(p -> p.getRatings().add(rating));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(pairs[1]);
                    if (plants.stream().anyMatch(findPlant)) {
                        plants.stream().filter(findPlant).findFirst().ifPresent(p -> p.setRarity(newRarity));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plants.stream().anyMatch(findPlant)) {
                        plants.stream().filter(findPlant).findFirst().ifPresent(p -> p.setRatings(new ArrayList<>()));
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
        }
            System.out.println("Plants for the exhibition:");
            plants.stream()
                    .sorted(Comparator.comparing(Plant::getRarity).reversed()
                            .thenComparing(Comparator.comparing(Plant::getAverageRating).reversed()))
                    .forEach(System.out::println);
    }

    public static class Plant {
        private String name;
        private int rarity;
        private List<Double> ratings;

        public Plant(String name) {
            this.name = name;
            this.rarity = 0;
            this.ratings = new ArrayList<>();
        }

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Double> getRatings() {
            return ratings;
        }

        public void setRatings(List<Double> ratings) {
            this.ratings = ratings;
        }

        public double getAverageRating() {
            return ratings.stream().mapToDouble(e -> e).average().orElse(0);
        }

        @Override
        public String toString() {
            return String.format("- %s; Rarity: %d; Rating: %.2f",
                    this.getName(), this.getRarity(), this.getAverageRating());
        }
    }


}
