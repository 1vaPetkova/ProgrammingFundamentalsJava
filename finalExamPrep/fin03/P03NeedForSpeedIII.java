package finalExamPrep.fin03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalCars = Integer.parseInt(scan.nextLine());
        Map<String, Integer> mileage = new TreeMap<>();
        Map<String, Integer> fuel = new TreeMap<>();
        for (int i = 0; i < totalCars; i++) {
            String text = scan.nextLine();
            String currentCar = text.split("\\|")[0];
            int currentMileage = Integer.parseInt(text.split("\\|")[1]);
            int currentFuel = Integer.parseInt(text.split("\\|")[2]);
            mileage.putIfAbsent(currentCar, 0);
            mileage.put(currentCar, currentMileage);
            fuel.putIfAbsent(currentCar, 0);
            fuel.put(currentCar, currentFuel);
        }
        String input = "";
        while (!(input = scan.nextLine()).equals("Stop")) {
            String car = input.split("\\s+:\\s+")[1];
            switch (input.split("\\s+:\\s+")[0]) {
                case "Drive":
                    int distanceToDrive = Integer.parseInt(input.split("\\s+:\\s+")[2]);
                    int fuelTorDrive = Integer.parseInt(input.split("\\s+:\\s+")[3]);
                    if (fuel.get(car) < fuelTorDrive) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        fuel.put(car, fuel.get(car) - fuelTorDrive);
                        mileage.put(car, mileage.get(car) + distanceToDrive);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n"
                                , car, distanceToDrive, fuelTorDrive);
                    }
                    if (mileage.get(car) >= 100000) {
                        System.out.println("Time to sell the " + car + "!");
                        mileage.remove(car);
                        fuel.remove(car);
                    }
                    break;
                case "Refuel":
                    int fuelRefilled = Integer.parseInt(input.split("\\s+:\\s+")[2]);
                    int diffFuel = Math.min(fuel.get(car) + fuelRefilled, 75) - fuel.get(car);
                    fuel.put(car, Math.min(fuel.get(car) + fuelRefilled, 75));
                    System.out.printf("%s refueled with %d liters\n", car, diffFuel);
                    break;
                case "Revert":
                    int kmDecreased = Integer.parseInt(input.split("\\s+:\\s+")[2]);
                    if (mileage.get(car) - kmDecreased >= 10000) {
                        mileage.put(car, mileage.get(car) - kmDecreased);
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, kmDecreased);
                    } else {
                        mileage.put(car, 10000);
                    }
                    break;
            }
        }
        mileage.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                        e.getKey(), e.getValue(), fuel.get(e.getKey())));
    }
}
