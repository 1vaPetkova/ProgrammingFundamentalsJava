package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P02sumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int sumDigits = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sumDigits += lastDigit;
            number /= 10;
        }
        System.out.println(sumDigits);
    }
}
