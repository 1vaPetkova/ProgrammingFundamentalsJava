package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01trainv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());
        int[] peoplePerWagon = new int[wagons];
        for (int i = 0; i < wagons; i++) {
            peoplePerWagon[i] = Integer.parseInt(scan.nextLine());
            System.out.print(peoplePerWagon[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.stream(peoplePerWagon).sum());
    }
}
