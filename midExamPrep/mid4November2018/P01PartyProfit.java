package midExamPrep.mid4November2018;

import java.util.Scanner;

public class P01PartyProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int partySize = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());
        int earnings = 0;
        for (int i = 1; i <= days; i++) {
            earnings += 50;
            earnings -= 2 * partySize;
            if (i % 3 == 0) {
                earnings -= 3 * partySize;
            }
            if (i % 5 == 0) {
                earnings += 20 * partySize;
            }
            if (i % 15 == 0) {
                earnings -= 2 * partySize;
            }
            if (i % 9 == 0) {
                partySize -= 2;
            }
            if (i % 14 == 0) {
                partySize += 5;
            }
        }
        System.out.printf("%d companions received %.0f coins each.\n", partySize, Math.floor(1.0 * earnings / partySize));
    }
}
