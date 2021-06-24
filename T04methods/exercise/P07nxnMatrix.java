package T04methods.exercise;

import java.util.Scanner;

public class P07nxnMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        System.out.println(printMatrix(num));
    }

    static String printMatrix(int num) {
        String matrixRow = setRow(num);
        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            outputBuilder.append(String.format("%s\n", matrixRow));
        }
        return outputBuilder.toString();
    }

    static String setRow(int num) {
        int[] array = new int[num];
        StringBuilder matrixBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
            matrixBuilder.append(array[i]);
            matrixBuilder.append(" ");
        }
        return matrixBuilder.toString();
    }
}
