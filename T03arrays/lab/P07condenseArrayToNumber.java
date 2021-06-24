package T03arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P07condenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        int[] nums = Arrays.stream(array).mapToInt(e -> Integer.parseInt(e)).toArray();
        int output = nums[0];
        while (nums.length > 1) {
            int[] condensed = new int[nums.length - 1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = nums[i] + nums[i + 1];
            }
            nums = condensed;
            output = nums[0];
        }
        System.out.println(output);
    }
}
