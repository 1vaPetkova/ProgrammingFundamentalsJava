package T03arrays.archive;

import java.util.Scanner;

public class P01largestCommonEnd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input1 = scan.nextLine().split(" ");
        String[] input2 = scan.nextLine().split(" ");

        int minLength = Math.min(input1.length, input2.length);
        int maxLength = Math.max(input1.length, input2.length);
        String[] shorter = new String[minLength];
        String[] longer = new String[maxLength];

        if (input1.length == minLength) {
            shorter = input1;
            longer = input2;
        } else {
            longer = input1;
            shorter = input2;
        }

        int countCommonLeft = 0;
        for (int i = 0; i < minLength; i++) {
            if (shorter[i].equals(longer[i])) {
                countCommonLeft++;
            } else {
                break;
            }
        }
        int diff = maxLength-minLength;
        int countCommonRight = 0;
        for (int j = maxLength-1; j >=diff; j--) {
            if (shorter[j-diff].equals(longer[j])){
                countCommonRight++;
            } else {
                break;
            }
        }
        int countCommon = Math.max(countCommonLeft,countCommonRight);
        System.out.println(countCommon);
    }
}
