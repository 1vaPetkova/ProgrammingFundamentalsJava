package finalExamPrep.fin05v2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> townPopulation = new TreeMap<>();
        Map<String, Integer> townGold = new TreeMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("Sail")) {
            //Tortuga||345000||1250
            String[] tokens = input.split("\\|\\|");
            String town = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            townPopulation.putIfAbsent(town, 0);
            townPopulation.put(town, townPopulation.get(town) + population);
            townGold.putIfAbsent(town, 0);
            townGold.put(town, townGold.get(town) + gold);
        }

        String txt = "";
        while (!(txt = scan.nextLine()).equals("End")) {
            String[] commands = txt.split("=>");
            String currentTown = commands[1];
            switch (commands[0]) {
                case "Plunder":
                    int currPeople = Integer.parseInt(commands[2]);
                    int currGold = Integer.parseInt(commands[3]);
                    townPopulation.put(currentTown, townPopulation.get(currentTown) - currPeople);
                    townGold.put(currentTown, townGold.get(currentTown) - currGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",
                            currentTown, currGold, currPeople);
                    if (townPopulation.get(currentTown) <= 0 || townGold.get(currentTown) <= 0) {
                        townPopulation.remove(currentTown);
                        townGold.remove(currentTown);
                        System.out.println(currentTown + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    currGold = Integer.parseInt(commands[2]);
                    if (currGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        townGold.put(currentTown, townGold.get(currentTown) + currGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                                currGold, currentTown, townGold.get(currentTown));
                    }
                    break;
            }
        }
        if (!townGold.isEmpty() && !townPopulation.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", townPopulation.size());
            townGold.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                            e.getKey(), townPopulation.get(e.getKey()), e.getValue()));
        }
    }
}
