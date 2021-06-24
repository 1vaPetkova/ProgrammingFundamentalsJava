package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P11equalSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqual = false;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int leftNumbers = 0; leftNumbers < i; leftNumbers++) {
                sumLeft += array[leftNumbers];
            }
            for (int rightNumbers = i + 1; rightNumbers < array.length; rightNumbers++) {
                sumRight += array[rightNumbers];
            }
            if (sumLeft == sumRight) {
                isEqual = true;
                index = i;
                break;
            }
        }
        if (isEqual) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
