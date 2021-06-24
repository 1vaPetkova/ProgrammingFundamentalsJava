package midExamPrep.mid03;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = "";
        int targetsShot = 0;
        while (!(input = scan.nextLine()).equals("End")) {
            int currentIndex = Integer.parseInt(input);
            if (currentIndex >= 0 && currentIndex < array.length && array[currentIndex] != -1) {
                int currentValue = array[currentIndex];
                for (int i = 0; i < array.length; i++) {
                    if (i != currentIndex && array[i] != -1) {
                        if (array[i] > currentValue) {
                            array[i] -= currentValue;
                        } else if (array[i] <= currentValue) {
                            array[i] += currentValue;
                        }
                    }
                }
                array[currentIndex] = -1;
                targetsShot++;
            }
        }
        System.out.printf("Shot targets: %d -> ", targetsShot);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
