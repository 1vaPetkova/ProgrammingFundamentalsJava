package T03arrays.exercise;

import java.util.Scanner;

public class P01train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());
        int sumPeople = 0;
        int[] peoplePerWagon = new int[wagons];

        for (int i = 0; i < wagons; i++) {
            peoplePerWagon[i] = Integer.parseInt(scan.nextLine());
            sumPeople += peoplePerWagon[i];
            System.out.print(peoplePerWagon[i] + " ");
        }
        System.out.println();
        System.out.println(sumPeople);
    }
}
