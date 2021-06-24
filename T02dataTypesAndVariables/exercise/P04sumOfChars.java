package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P04sumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int characters = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < characters; i++) {
            char symbol = scan.nextLine().charAt(0);
            sum += symbol;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
