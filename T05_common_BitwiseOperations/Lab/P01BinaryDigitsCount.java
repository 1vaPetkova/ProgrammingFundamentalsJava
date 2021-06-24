package T05_common_BitwiseOperations.Lab;

import java.util.Scanner;

public class P01BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int binaryNumber = Integer.parseInt(scan.nextLine());
        int count = 0;
        while (number > 0) {
            int leftover = number % 2;
            if (leftover == binaryNumber) {
                count++;
            }
            number/=2;
        }
        System.out.println(count);
    }
}
