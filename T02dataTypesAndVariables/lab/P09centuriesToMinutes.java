package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P09centuriesToMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int centuries = Integer.parseInt(scan.nextLine());
        int years = 100 * centuries;
       double days = 365.2422 * years;
        double hours =  24*days;
       double minutes =  60*hours;
        System.out.printf("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes",centuries,years,days, hours, minutes);
    }
}
