package midExamPrep.midRetake18December2018;

import java.util.Arrays;
import java.util.Scanner;

public class P03PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] presents = Arrays.stream(scan.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = "";
        int currentIndex = 0;
        while (!(input = scan.nextLine()).equals("Merry Xmas!")) {
            int length = Integer.parseInt(input.split("\\s+")[1]);
            currentIndex += length;
            if (currentIndex >= presents.length) {
                currentIndex = currentIndex % (presents.length);
            }
            if (presents[currentIndex] <= 0) {
                presents[currentIndex] = 0;
                System.out.printf("House %d will have a Merry Christmas.\n", currentIndex);
            } else {
                presents[currentIndex] -= 2;
            }
        }
        int notDelivered = 0;
        for (int present : presents) {
            if (present > 0) {
                notDelivered++;
            }
        }
        System.out.printf("Santa's last position was %d.\n", currentIndex);
        if (notDelivered == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Santa has failed %s houses.\n", notDelivered);
        }
    }
}
