package midExamPrep.mid00v2;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double plunderGained = 0;
        for (int i = 1; i <= days; i++) {
            plunderGained += dailyPlunder;
            if (i % 3 == 0) {
                plunderGained += 0.5 * dailyPlunder;
            }
            if (i % 5 == 0) {
                plunderGained*=0.7;
            }
        }
        if (plunderGained >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunderGained);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.",100*plunderGained/expectedPlunder);
        }
    }
}
