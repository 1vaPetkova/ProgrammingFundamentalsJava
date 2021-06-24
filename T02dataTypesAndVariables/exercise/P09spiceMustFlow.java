package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P09spiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startYield = Integer.parseInt(scan.nextLine());
        int countDays = 0;
        int sumSpice = 0;

        while (startYield >= 100) {
            sumSpice += startYield-26;
            countDays++;
            //startYield for the nextDay
            startYield -= 10;
        }
        if (sumSpice >= 26) {
            sumSpice -= 26;
        } else {
            sumSpice = 0;
        }
        System.out.println(countDays);
        System.out.println(sumSpice);
    }
}
