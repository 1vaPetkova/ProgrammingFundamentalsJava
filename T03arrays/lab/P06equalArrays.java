package T03arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06equalArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean areIdentical = false;
        int sum = 0;
        int falseIndex = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == secondArray[i]) {
                areIdentical = true;
                sum += firstArray[i];
            } else {
                areIdentical = false;
                falseIndex = i;
                break;
            }
        }
        if (areIdentical){
            System.out.printf("Arrays are identical. Sum: %d\n",sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.",falseIndex);
        }
    }
}
