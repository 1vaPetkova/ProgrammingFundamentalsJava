package finalExamPrep.fin03v2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        Map<String, Integer> carsMileage = new TreeMap<>();
        Map<String, Integer> carsFuel = new TreeMap<>();

        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            carsMileage.put(car, mileage);
            carsFuel.put(car, fuel);
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("Stop")) {
            String[] info = input.split(" : ");
            String currentCar = info[1];
            switch (info[0]) {
                case "Drive":
                    int distanceToDrive = Integer.parseInt(info[2]);
                    int fuelNeeded = Integer.parseInt(info[3]);
                    if (carsFuel.get(currentCar) < fuelNeeded) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carsFuel.put(currentCar, carsFuel.get(currentCar) - fuelNeeded);
                        carsMileage.put(currentCar, carsMileage.get(currentCar) + distanceToDrive);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n"
                                , currentCar, distanceToDrive, fuelNeeded);
                        if (carsMileage.get(currentCar) >= 100000) {
                            System.out.println("Time to sell the " + currentCar + "!");
                            carsFuel.remove(currentCar);
                            carsMileage.remove(currentCar);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelToAdd = Integer.parseInt(info[2]);
                    int newFuelValue = Math.min(75, carsFuel.get(currentCar) + fuelToAdd);
                    int fuelDiff = newFuelValue - carsFuel.get(currentCar);
                    carsFuel.put(currentCar, newFuelValue);
                    System.out.printf("%s refueled with %d liters\n", currentCar, fuelDiff);
                    break;
                case "Revert":
                    int kmToDecrease = Integer.parseInt(info[2]);
                    if (carsMileage.get(currentCar) - kmToDecrease >= 10000) {
                        carsMileage.put(currentCar, carsMileage.get(currentCar) - kmToDecrease);
                        System.out.printf("%s mileage decreased by %d kilometers\n", currentCar, kmToDecrease);
                    } else {
                        carsMileage.put(currentCar, 10000);
                    }
                    break;
            }
        }
        carsMileage.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                        e.getKey(), e.getValue(), carsFuel.get(e.getKey())));
    }
}
