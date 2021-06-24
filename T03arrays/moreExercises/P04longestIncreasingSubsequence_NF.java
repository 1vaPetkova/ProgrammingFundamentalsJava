package T03arrays.moreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04longestIncreasingSubsequence_NF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


    }
}

