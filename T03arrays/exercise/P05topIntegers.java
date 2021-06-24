package T03arrays.exercise;


import java.util.Arrays;
import java.util.Scanner;

public class P05topIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            boolean isBigger = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(array[i] + " ");
            }
        }
        //for the last digit of the array
        System.out.print(array[array.length - 1]);
    }
}
