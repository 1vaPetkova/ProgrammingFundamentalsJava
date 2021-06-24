package T03arrays.lab;

import java.util.Scanner;

public class P03sumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] array = input.split(" ");
        int sumEven = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = Integer.parseInt(array[i]);
                if (currentNum%2==0){
                    sumEven+=currentNum;
                }
        }
        System.out.println(sumEven);
    }
}
