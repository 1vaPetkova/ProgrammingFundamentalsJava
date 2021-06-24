package T04methods.moreExercise;

import java.util.Scanner;

public class P05multiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        checkPlusMinusZero(num1, num2, num3);
    }

    private static void checkPlusMinusZero(int num1, int num2, int num3) {
        int countMinuses = 0;
        if (num1 < 0) {
            countMinuses++;
        }
        if (num2 < 0) {
            countMinuses++;
        }
        if (num3 < 0) {
            countMinuses++;
        }
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            System.out.println("zero");
        } else if (countMinuses%2==0){
            System.out.println("positive");
        } else{
            System.out.println("negative");
        }
    }
}
