package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P10pairsByDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int difference = Integer.parseInt(scan.nextLine());

        int countpairs = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Math.abs(array[i] - array[j]) == difference) {
                    countpairs++;
                }
            }
        }
        System.out.println(countpairs);
    }
}
