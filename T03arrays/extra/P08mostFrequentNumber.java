package T03arrays.archive;

import java.util.Arrays;
import java.util.Scanner;

public class P08mostFrequentNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = 0;
        int totalOccurances = 0;

        for (int i = 0; i < array.length; i++) {
            int currentOccurances=0;
            for (int j = i; j < array.length; j++) {
                if (array[i]==array[j]) {
                    currentOccurances++;
                    if (currentOccurances > totalOccurances) {
                        totalOccurances = currentOccurances;
                        number = array[i];
                    }
                }
            }
        }
        System.out.println(number);
    }
}
