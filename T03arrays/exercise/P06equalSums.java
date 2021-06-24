package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P06equalSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int index = 0;
        boolean isEqual = false;
        for (int i = 0; i < array.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            //сума на числата вляво
                for (int j = 0; j < i; j++) {
                    sumLeft += array[j];
            }
            //сума на числата вдясно
                for (int k = i + 1; k < array.length; k++) {
                    sumRight += array[k];
            }
            if (sumLeft == sumRight) {
                isEqual = true;
                index = i;
                break;
            } else {
                isEqual = false;
            }
        }
        if (isEqual) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}

