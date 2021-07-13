package T03arrays.moreExercises;

import java.util.Scanner;

public class P02pascalTrianglev2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        long countRows = Integer.parseInt(scan.nextLine());

        for (long i = 0; i < countRows; i++) {
            long number = 1;
            for (long j = 0; j <= i; j++) {
                if (j < i) {
                    System.out.print(number + " ");
                } else {
                    System.out.print(number);
                }
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}






