package midExamPrep.RetakeExamPartOne06012017;

import java.util.Scanner;

public class P01SinoTheWalkerv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] leaveTime = scan.nextLine().split(":");
        //86400 - seconds in one day
        int stepsTaken = Integer.parseInt(scan.nextLine()) % 86400;
        int timePerStep = Integer.parseInt(scan.nextLine()) % 86400;
        int leaveTimeInSec = (Integer.parseInt(leaveTime[2]) +
                Integer.parseInt(leaveTime[1]) * 60 + Integer.parseInt(leaveTime[0]) * 3600);
        int arrivalTimeInSec = leaveTimeInSec + stepsTaken * timePerStep;

        int hours = arrivalTimeInSec / 3600 % 24;
        int minutes = arrivalTimeInSec % 3600 / 60;
        int seconds = arrivalTimeInSec % 3600 % 60;

        System.out.printf("Time Arrival: %02d:%02d:%02d", hours, minutes, seconds);
    }
}

