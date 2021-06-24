package T04methods.еxerciseЕlena;

import java.util.Scanner;

public class P07primesInGivenRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        boolean noPrimes = false;
        if (FindPrimesInRange(start, end).equals("")) {
            System.out.print("(empty list)");
        } else {
            System.out.print(FindPrimesInRange(start, end));
        }
    }
// other option:
//     try {System.out.print(FindPrimesInRange(start, end);
//
//    } catch (Exception e) {
//        System.out.print("(empty list)");
//    }
//}
    static String FindPrimesInRange(int start, int end) {
        String output = "";
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                output += String.valueOf(i) + ", ";
            }
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }

    static boolean isPrime(int number) {
       // boolean isPrime = true;
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

