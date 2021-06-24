package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P06maxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int counter = 1;
        int maxSequence = 1;
        int num = 0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]==array[i+1]){
                counter++;
            } else {
                counter=1;
            }
            if (counter>maxSequence){
                maxSequence=counter;
                num = array[i];
            }
        }
        for (int j = 0; j < maxSequence; j++) {
            System.out.print(num + " ");
        }
    }
}
