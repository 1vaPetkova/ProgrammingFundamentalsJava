package T01basicSyntax.lab;

import java.util.Scanner;

public class P11multiplicationTable2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int mult = Integer.parseInt(scan.nextLine());
        if (mult>10){
            System.out.printf("%d X %d = %d\n", num, mult, num * mult);
        }
        while (mult <= 10) {
            System.out.printf("%d X %d = %d\n", num, mult, num * mult);
            mult++;
        }

    }
}