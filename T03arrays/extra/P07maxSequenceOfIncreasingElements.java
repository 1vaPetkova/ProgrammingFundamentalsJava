package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P07maxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startIndex = 0;
        int currentLength = 1;
        int maxStart = 0;
        int maxLength = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] > array[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = startIndex;
                }
            } else {
                currentLength = 1;
                startIndex = i;
            }
        }
        for (int j = maxStart; j < maxStart + maxLength; j++) {
            System.out.print(array[j] + " ");
        }
    }
}

