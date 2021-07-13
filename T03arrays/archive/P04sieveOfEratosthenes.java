package T03arrays.archive;

import java.util.ArrayList;
import java.util.Scanner;

public class P04sieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        boolean[] primes = new boolean[number + 1];//from 0 to the given number n included
        for (int index = 2; index < primes.length; index++) {
            primes[index] = true;
        }
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= number; j += i) {
                    primes[j] = false;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int k = 0; k < primes.length; k++) {
            if (primes[k]) {
                result.add(k);
            }
        }
        String result1 = result.toString().replaceAll("\\[|\\]", "");
        result1 = result1.replace(",", "");
        System.out.println(result1);
    }
}
