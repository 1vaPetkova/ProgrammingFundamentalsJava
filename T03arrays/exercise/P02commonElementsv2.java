package T03arrays.exercise;

import java.util.Scanner;

public class P02commonElementsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArray = scan.nextLine().split(" ");
        String[] secondArray = scan.nextLine().split(" ");

        for (String second : secondArray) {
            for (String first : firstArray) {
                if (second.equals(first)) {
                    System.out.print(second + " ");
                }
            }
        }
    }
}

