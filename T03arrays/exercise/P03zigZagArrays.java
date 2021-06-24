package T03arrays.exercise;

import java.util.Scanner;

public class P03zigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] firstArray = new String[n];
        String[] secondArray = new String[n];
        for (int i = 0; i < n; i++) {
            String[] temp = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArray[i] = temp[0];
                secondArray[i] = temp[temp.length - 1];
            } else {
                secondArray[i] = temp[0];
                firstArray[i] = temp[temp.length - 1];
            }
        }
        System.out.println(String.join(" ",firstArray));
        System.out.println(String.join(" ",secondArray));
    }

}

