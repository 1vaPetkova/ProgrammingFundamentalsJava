package midExamPrep.RetakeExamPartOne06012017;

import java.util.Scanner;

public class P01SinoTheWalker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] leaveTime = scan.nextLine().split(":");
        int stepsTaken = Integer.parseInt(scan.nextLine())%86400;
        int timePerStep = Integer.parseInt(scan.nextLine())%86400;
        int leaveTimeInSec = (Integer.parseInt(leaveTime[2]) +
                Integer.parseInt(leaveTime[1]) * 60 + Integer.parseInt(leaveTime[0]) * 3600);
        int arrivalTimeInSec = leaveTimeInSec + stepsTaken * timePerStep;

        int hours = 0;
        while (arrivalTimeInSec >= 3600) {
            hours++;
            arrivalTimeInSec -= 3600;
        }
        if (hours > 23) {
            hours = hours % 24;
        }
        int minutes = 0;
        while (arrivalTimeInSec >= 60) {
            minutes++;
            arrivalTimeInSec -= 60;
        }
        System.out.printf("Time Arrival: %02d:%02d:%02d", hours, minutes, arrivalTimeInSec);
    }
}

