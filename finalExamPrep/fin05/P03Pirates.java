package finalExamPrep.fin05;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstInput = "";
        Map<String, Integer> cities = new TreeMap<>();
        Map<String, Integer> gold = new TreeMap<>();
        while (!(firstInput = scan.nextLine()).equals("Sail")) {
            String city = firstInput.split("\\|\\|")[0];
            int population = Integer.parseInt(firstInput.split("\\|\\|")[1]);
            int currGold = Integer.parseInt(firstInput.split("\\|\\|")[2]);
            cities.putIfAbsent(city, 0);
            cities.put(city, cities.get(city) + population);
            gold.putIfAbsent(city, 0);
            gold.put(city, gold.get(city) + currGold);
        }
        String secondInput = "";
        while (!(secondInput = scan.nextLine()).equals("End")) {
            String town = secondInput.split("=>")[1];
            switch (secondInput.split("=>")[0]) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(secondInput.split("=>")[2]);
                    int goldPlundered = Integer.parseInt(secondInput.split("=>")[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, goldPlundered, peopleKilled);
                    cities.put(town, cities.get(town) - peopleKilled);
                    gold.put(town, gold.get(town) - goldPlundered);
                    if (cities.get(town) == 0 | gold.get(town) == 0) {
                        System.out.printf("%s has been wiped off the map!\n", town);
                        cities.remove(town);
                        gold.remove(town);
                    }
                    break;
                case "Prosper":
                    int goldProspered = Integer.parseInt(secondInput.split("=>")[2]);
                    if (goldProspered < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        gold.put(town, gold.get(town) + goldProspered);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", goldProspered, town, gold.get(town));
                    }
                    break;
            }
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",cities.size());
        gold.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).forEach(t->{
            System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",t.getKey(),cities.get(t.getKey()),t.getValue());
        });
    }
}
