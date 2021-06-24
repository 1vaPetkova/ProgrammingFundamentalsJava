package T03arrays.moreExercises;

import java.util.Scanner;

public class P01encryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        int[] result = new int[number];

        for (int i = 0; i < number; i++) {
            String[] input = scan.nextLine().split("");
            int sum = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("a") || input[j].equals("e") || input[j].equals("i") || input[j].equals("o") || input[j].equals("u")
                ||input[j].equals("A") || input[j].equals("E") || input[j].equals("I") || input[j].equals("O") || input[j].equals("U")) {
                    int vowel = input[j].charAt(0);
                    sum += input.length * vowel;
                } else {
                    int consonant = input[j].charAt(0);
                    sum += consonant / input.length;
                }
            }
            result[i] = sum;
        }

        int temp = 0;
        for (int k = 0; k < result.length; k++) {
            for (int l = k + 1; l < result.length; l++) {
                if (result[k] > result[l]) {
                    temp = result[k];
                    result[k] = result[l];
                    result[l] = temp;
                }
            }
            System.out.println(result[k]);
        }
    }
}

