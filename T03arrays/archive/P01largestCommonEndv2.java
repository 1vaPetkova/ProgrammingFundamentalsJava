package T03arrays.archive;

import java.util.Scanner;

public class P01largestCommonEndv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input1 = scan.nextLine().split(" ");
        String[] input2 = scan.nextLine().split(" ");


        int countCommon = 0;
        for (int i = 0; i < Math.min(input1.length, input2.length); i++) {
            if (input1[i].equals(input2[i])) {
                countCommon++;
            } else if (input1[input1.length - 1 - i].equals(input2[input2.length - 1 - i])) {
                countCommon++;
            } else {
                break;
            }
        }

        System.out.println(countCommon);
    }
}
