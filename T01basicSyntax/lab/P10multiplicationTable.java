package T01basicSyntax.lab;

import java.util.Scanner;

public class P10multiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <=10 ; i++) {
            System.out.printf("%d X %d = %d\n",num,i,num*i);
        }
    }
}
