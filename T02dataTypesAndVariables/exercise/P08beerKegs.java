package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P08beerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
       double maxVolume = Double.NEGATIVE_INFINITY;
        String biggestKeg = "";
        for (int i = 0; i < n; i++) {
         String model = scan.nextLine();
           double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double kegVolume = (Math.PI * Math.pow(radius, 2) * height);
            if (kegVolume > maxVolume) {
                maxVolume = kegVolume;
                biggestKeg = model;
            }
        }
        System.out.println(biggestKeg);
    }
}
