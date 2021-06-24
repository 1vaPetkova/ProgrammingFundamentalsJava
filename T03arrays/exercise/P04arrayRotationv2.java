package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04arrayRotationv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < rotations; i++) {
            int firstNum = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstNum;
        }
        for (int number : array) {
            System.out.print(number + " ");
        }
    }
}
