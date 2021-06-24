package T04methods.еxerciseЕlena;

import java.util.Scanner;

public class P05fibonacciNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printFibonacciNumber(number);
    }

    private static void printFibonacciNumber(int number) {
        int f0 = 0;
        int f1 = 1;
        for (int i = 0; i < number; i++) {
            int nf = f0+f1;
            f0 = f1;
            f1 = nf;
        }
        System.out.println(f1);
        }

    }

