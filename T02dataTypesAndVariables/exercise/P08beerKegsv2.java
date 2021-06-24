package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P08beerKegsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte n = Byte.parseByte(scan.nextLine());
        float maxVolume = Float.MIN_VALUE;
        String biggestKeg = "";
        for (byte i = 0; i < n; i++) {
            String model = scan.nextLine();
            float radius = Float.parseFloat(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            float kegVolume = (float) (Math.PI * Math.pow(radius, 2) * height);
            if (kegVolume > maxVolume) {
                maxVolume = kegVolume;
                biggestKeg = model;
            }
        }
        System.out.println(biggestKeg);
    }
}
