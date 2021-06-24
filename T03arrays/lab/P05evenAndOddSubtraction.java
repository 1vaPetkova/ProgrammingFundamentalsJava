package T03arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05evenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] array = Arrays.stream(input).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }
        int diff = sumEven - sumOdd;
        System.out.println(diff);
    }
}
