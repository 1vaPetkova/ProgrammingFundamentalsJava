package midExamPrep.mid10March2019;

import java.util.Scanner;

public class P01SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int daysOfTheTrip = Integer.parseInt(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());
        int people = Integer.parseInt(scan.nextLine());
        double fuelPricePerKm = Double.parseDouble(scan.nextLine());
        double foodPerPersonPerDay = Double.parseDouble(scan.nextLine());
        double accommodationPerPersonPerDay = Double.parseDouble(scan.nextLine());
        if (people > 10) {
            accommodationPerPersonPerDay *= .75;
        }
        boolean isOver = false;
        double accommodationSum = daysOfTheTrip * people * accommodationPerPersonPerDay;
        double foodExpenses = daysOfTheTrip * people * foodPerPersonPerDay;
        double currentExpenses = accommodationSum + foodExpenses;
        if (currentExpenses > budget) {
            isOver = true;
        }
        for (int i = 1; i <= daysOfTheTrip; i++) {
            double travelledDistancePerDay = Double.parseDouble(scan.nextLine());
            currentExpenses += travelledDistancePerDay * fuelPricePerKm;
            if (currentExpenses > budget) {
                isOver = true;
                break;
            }
            if (i % 3 == 0 | i % 5 == 0) {
                currentExpenses *= 1.4;
                if (currentExpenses > budget) {
                    isOver = true;
                    break;
                }
            }
            if (i % 7 == 0) {
                currentExpenses -= (currentExpenses / people);
            }
        }
        if (isOver) {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.\n",currentExpenses-budget);
        } else {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.\n",
                    budget-currentExpenses);
        }
    }
}
