package T01basicSyntax.moreExercises;

import java.util.Scanner;

public class P01sortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        int max1 = Math.max(a, b);
        int max = Math.max(max1, c);
        int min1 = Math.min(a, b);
        int min = Math.min(min1, c);
        int sum = a + b + c;
        int mid = sum-max-min;
        System.out.println(max);
        System.out.println(mid);
        System.out.println(min);
    }
}
