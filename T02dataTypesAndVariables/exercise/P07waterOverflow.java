package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P07waterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        int tankCapacity = 255;
        int litresPoured = 0;
        for (int i = 0; i < lines; i++) {
            int litres = Integer.parseInt(scan.nextLine());
            litresPoured += litres;
            if (tankCapacity < litresPoured) {
                litresPoured -= litres;
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(litresPoured);
    }
}
