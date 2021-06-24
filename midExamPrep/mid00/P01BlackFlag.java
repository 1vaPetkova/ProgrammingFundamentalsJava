package midExamPrep.mid00;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double gainedPlunder = 0;
        for (int i = 1; i <= days; i++) {
            gainedPlunder += dailyPlunder;
            if (i % 3 == 0) {
                gainedPlunder += 0.5 * dailyPlunder;
            }
            if (i % 5 == 0) {
                gainedPlunder -= 0.3 * gainedPlunder;
            }
        }
        if (gainedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", gainedPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", 100 * gainedPlunder / expectedPlunder);
        }
    }
}

