package T01basicSyntax.lab;

import java.util.Scanner;

public class P11multiplicationTable2v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int mult = Integer.parseInt(scan.nextLine());
        do {
            System.out.printf("%d X %d = %d\n", num, mult, num * mult);
            mult++;
        } while (mult <= 10);
    }
}