package T04methods.extra;

import java.util.Scanner;

public class P06PrimeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long number = Long.parseLong(scan.nextLine());
        if (isPrime(number)) {
            System.out.println("True");
        } else{
            System.out.println("False");
        }
    }

    private static boolean isPrime(long number) {
        boolean isPrime = true;
        if (number == 0 || number == 1) {
            isPrime = false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}


