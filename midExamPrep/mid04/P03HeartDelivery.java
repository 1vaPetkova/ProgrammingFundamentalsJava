package midExamPrep.mid04;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] hearts = Arrays.stream(scan.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = "";
        int jumpIndex = 0;
        while (!(input = scan.nextLine()).equals("Love!")) {
            jumpIndex +=Integer.parseInt(input.split(" ")[1]);
            if (jumpIndex > hearts.length-1) {
                jumpIndex = 0;
            }
            if (hearts[jumpIndex] > 0) {
                hearts[jumpIndex] -= 2;
                if (hearts[jumpIndex] <= 0) {
                    hearts[jumpIndex] = 0;
                    System.out.printf("Place %d has Valentine's day.\n", jumpIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.\n",jumpIndex);
            }
        }
        System.out.printf("Cupid's last position was %d.\n",jumpIndex);
        int failed = 0;

        for (int i = 0; i < hearts.length; i++) {
            if(hearts[i]!=0){
                failed++;
            }
        }
        if(failed==0){
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.",failed);
        }
    }
}
