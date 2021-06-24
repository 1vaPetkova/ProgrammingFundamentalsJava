package T03arrays.moreExercises;

import java.util.Scanner;

public class P03recursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        if (n <= 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            long[] array = new long[n];
            for (int i = 0; i < array.length; i++) {
                if (i < 2) {
                    array[i] = 1;
                } else {
                    long sum = array[i - 2] + array[i - 1];
                    array[i] = sum;
                }
            }
            System.out.print(array[array.length - 1]);
        }
    }
}

