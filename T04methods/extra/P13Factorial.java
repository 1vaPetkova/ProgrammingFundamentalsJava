package T04methods.extra;

import java.math.BigInteger;
import java.util.Scanner;

public class P13Factorial {
    public static BigInteger[] memory;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        memory = new BigInteger[n + 1];
        System.out.println(fact(n));
    }

    private static BigInteger fact(int n) {
        //bottom
        if (n == 0) {
            return BigInteger.valueOf(1);
        }
            return memory[n] = fact(n - 1).multiply(BigInteger.valueOf(n));
        }
    }

