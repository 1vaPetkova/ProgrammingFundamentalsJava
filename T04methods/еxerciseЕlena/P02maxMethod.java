package T04methods.еxerciseЕlena;

import java.util.Scanner;

public class P02maxMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());

        int max1 = Math.max(firstNumber,secondNumber);
        getMax(max1, thirdNumber);

    }

    private static void getMax(int max1, int thirdNumber) {
        System.out.println(Math.max(max1,thirdNumber));
    }
}
