package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04arrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < rotations; i++) {
            String[] rotated = new String[array.length];
            rotated[rotated.length - 1] = array[0];
            for (int j = 0; j < rotated.length - 1; j++) {
                rotated[j] = array[j + 1];
            }
            array = rotated;
        }
        System.out.println(String.join(" ",array));
    }
}
