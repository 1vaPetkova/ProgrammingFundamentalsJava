package midExamPrep.Е05;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int lecturesInCourse = Integer.parseInt(scan.nextLine());
        int additionalBonusToCourse = Integer.parseInt(scan.nextLine());
        double currentBonus = 0;
        double maxBonus = 0;
        int maxStudentAttendance = 0;
        for (int i = 0; i < students; i++) {
            int attendance = Integer.parseInt(scan.nextLine());
            currentBonus = (1.0 * attendance / lecturesInCourse) * (5 + additionalBonusToCourse);
            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                maxStudentAttendance = attendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.",maxStudentAttendance);
    }
}
