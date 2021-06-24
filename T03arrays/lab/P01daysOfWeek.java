package T03arrays.lab;

import java.util.Scanner;

public class P01daysOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dayNumber = Integer.parseInt(scan.nextLine());

        String[] daysOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        if (dayNumber>=1&&dayNumber<=7){
            System.out.println(daysOfWeek[dayNumber-1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}
