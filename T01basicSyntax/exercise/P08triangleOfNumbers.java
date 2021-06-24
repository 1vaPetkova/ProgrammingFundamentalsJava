package T01basicSyntax.exercise;

import java.util.Scanner;

public class P08triangleOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int rows = 1; rows <=n ; rows++) {
            for (int columns = 1; columns <=rows ; columns++) {
                System.out.print(rows + " ");
            }
            System.out.println();
        }
    }
}
