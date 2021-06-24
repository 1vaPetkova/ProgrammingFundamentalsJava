package T01basicSyntax.lab;

import java.util.Scanner;

public class P09sumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
int sum = 0;
        for (int i = 1; i <=2*n ; i+=2) {
                sum+=i;
                System.out.println(i);

        }
        System.out.println("Sum: "+ sum);
    }
}
