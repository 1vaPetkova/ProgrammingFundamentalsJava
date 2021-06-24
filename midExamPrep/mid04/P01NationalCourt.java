package midExamPrep.mid04;

import java.util.Scanner;

public class P01NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstEmployeeCount = Integer.parseInt(scan.nextLine());
        int secondEmployeeCount = Integer.parseInt(scan.nextLine());
        int thirdEmployeeCount = Integer.parseInt(scan.nextLine());
        int totalPeople = Integer.parseInt(scan.nextLine());

        int hours = 0;
        int totalCustomersPerHour = firstEmployeeCount + secondEmployeeCount + thirdEmployeeCount;
        while (totalPeople > 0) {
            hours++;
            if (hours % 4 == 0) {
                continue;
            }
            totalPeople -= totalCustomersPerHour;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
