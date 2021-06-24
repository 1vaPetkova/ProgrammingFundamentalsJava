package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08magicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.println(array[i] + " " + array[j]);
                }
            }
        }
    }
}
