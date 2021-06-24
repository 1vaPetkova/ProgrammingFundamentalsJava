package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P02rotateAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int timesRotated = Integer.parseInt(scan.nextLine());
        int[] sum = new int[array.length];
        for (int rotations = 0; rotations < timesRotated; rotations++) {
            int[] rotated = new int[array.length];
            rotated[0] = array[array.length - 1];
            sum[0] += rotated[0];
            for (int i = 1; i < array.length; i++) {
                rotated[i] = array[i - 1];
                sum[i] += rotated[i];
            }
            array = rotated;
        }
        for (int value : sum) {
            System.out.print(value + " ");
        }
    }
}

