package T03arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08magicSumv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scan.nextLine());
        //oбхождане на всички числа
        for (int i = 0; i < array.length; i++) {
            int number1 = array[i];
            //обхождане на всички числа след моето
            for (int j = i+1; j < array.length; j++) {

                int number2 = array[j];
                if (number1+number2==sum){
                    System.out.printf("%d %d%n", number1, number2);
                }
            }

        }
    }
}
