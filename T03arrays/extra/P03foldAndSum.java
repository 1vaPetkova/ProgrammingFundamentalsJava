package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P03foldAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] firstRow = new int[array.length / 2];
        //firstRow leftSide
        for (int i = 0; i < firstRow.length / 2; i++) {
            firstRow[i] = array[array.length / 4 - 1 - i];
        }
        //firstRow rightSide
        for (int j = 0; j < firstRow.length / 2; j++) {
            firstRow[firstRow.length / 2 + j] = array[array.length - 1 - j];
        }
        //secondRow
        int[] secondRow = new int[array.length / 2];
        for (int m = 0; m < array.length / 2; m++) {
            secondRow[m] = array[m + array.length / 4];
        }
        int[] sum = new int[array.length / 2];

        //Printing
        for (int n = 0; n < array.length / 2; n++) {
            sum[n] = firstRow[n] + secondRow[n];
            System.out.print(sum[n] + " ");
        }

    }
}
