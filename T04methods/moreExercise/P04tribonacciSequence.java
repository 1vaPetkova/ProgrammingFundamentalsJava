package T04methods.moreExercise;

import java.util.Scanner;

public class P04tribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers = Integer.parseInt(scan.nextLine());
        returnTribonacciSequence(numbers);
    }
    private static void returnTribonacciSequence(int numbers) {
        int[] array = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            if (i == 0) {
                array[i] = 1;
            } else if (i == 1) {
                array[i] = 1;
            } else if (i == 2) {
                array[i] = 2;
            } else {
                array[i] = array[i - 3] + array[i - 2] + array[i - 1];
            }
        }
        String[] sequence = new String[numbers];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = String.valueOf(array[i]);
        }
        System.out.println(String.join(" ", sequence));
    }
}


