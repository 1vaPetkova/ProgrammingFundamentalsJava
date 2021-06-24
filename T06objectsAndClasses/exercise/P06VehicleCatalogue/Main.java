package T06objectsAndClasses.exercise.P06VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = "";
        List<Vehicle> list = new ArrayList<>();
        while (!(input1 = scan.nextLine()).equals("End")) {
            String type = input1.split("\\s+")[0];
            String model = input1.split("\\s+")[1];
            String colour = input1.split("\\s+")[2];
            double horsePower = Double.parseDouble(input1.split("\\s+")[3]);
            Vehicle vehicle = new Vehicle(type, model, colour, horsePower);
            list.add(vehicle);
        }
        String input2 = "";
        while (!(input2 = scan.nextLine()).equals("Close the Catalogue")) {
            String model = input2;
            List<Vehicle> filteredList = list.stream().filter(e -> e.getModel().equals(model))
                    .collect(Collectors.toList());
            for (Vehicle vehicle : filteredList) {
                System.out.print(vehicle);
            }
        }

        double sumHorsePowerCars = 0;
        double countCars = 0;
        double sumHorsePowerTrucks = 0;
        double countTrucks = 0;
        for (int i = 0; i < list.size(); i++) {
            String currentType = list.get(i).getType();
            if (currentType.equals("car")) {
                countCars++;
                sumHorsePowerCars += list.get(i).getHorsePower();
            } else {
                countTrucks++;
                sumHorsePowerTrucks += list.get(i).getHorsePower();
            }
        }

        double averageHorsePowerCars = 0;
        if (countCars != 0) {
            averageHorsePowerCars = sumHorsePowerCars / countCars;
        }

        double averageHorsePowerTrucks = 0;
        if (countTrucks != 0) {
            averageHorsePowerTrucks = sumHorsePowerTrucks / countTrucks;
        }

        System.out.printf("Cars have average horsepower of: %.2f.\n",averageHorsePowerCars);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHorsePowerTrucks);

    }
}
