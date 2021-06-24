package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P07maxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int num = array[0];
        int sequence = 1;
        int maxsequence = 1;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                sequence++;
            } else {
                sequence = 1;
            }
            if (sequence > maxsequence) {
                maxsequence = sequence;
                num = array[i];
            }
        }

        for (int j = 0; j < maxsequence; j++) {
            System.out.print(num + " ");
        }
    }
}