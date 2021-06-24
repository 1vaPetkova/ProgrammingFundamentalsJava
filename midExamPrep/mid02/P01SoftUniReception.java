package midExamPrep.mid02;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstCapacity = Integer.parseInt(scan.nextLine());
        int secondCapacity = Integer.parseInt(scan.nextLine());
        int thirdCapacity = Integer.parseInt(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());
        int hours = 0;
        while(studentsCount>0){
            studentsCount-=(firstCapacity+secondCapacity+thirdCapacity);
            hours++;
            if(hours%4==0){
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.",hours);
    }
}
