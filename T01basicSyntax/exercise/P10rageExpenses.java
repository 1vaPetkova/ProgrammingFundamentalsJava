package T01basicSyntax.exercise;

import java.util.Scanner;

public class P10rageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gamesLost = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        int headsets = 0;
        int mouses = 0;
        int keyboards = 0;
        int displays = 0;

        for (int i = 1; i <= gamesLost; i++) {
            if (i % 2 == 0) {
                headsets++;
            }
            if (i % 3 == 0) {
                mouses++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboards++;
            }
            if (i % 4 == 0 && i % 6 == 0 && keyboards > 0) {
                displays++;
            }
        }
        double sum = headsetPrice * headsets + mousePrice * mouses + keyboardPrice * keyboards + displayPrice * displays;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
