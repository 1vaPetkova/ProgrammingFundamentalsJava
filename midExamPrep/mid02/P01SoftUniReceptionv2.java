package midExamPrep.mid02;

import java.util.Scanner;

public class P01SoftUniReceptionv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstCapacity = Integer.parseInt(scan.nextLine());
        int secondCapacity = Integer.parseInt(scan.nextLine());
        int thirdCapacity = Integer.parseInt(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());
        int capacity = firstCapacity + secondCapacity + thirdCapacity;
        int hours=0;
        while (studentsCount>0) {
            studentsCount-=capacity;
            hours++;
            if(hours%4==0){
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.", Math.ceil(hours));
    }
}
