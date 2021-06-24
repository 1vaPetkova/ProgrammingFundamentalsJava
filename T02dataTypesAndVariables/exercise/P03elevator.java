package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P03elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte persons = scan.nextByte();
        byte capacity = scan.nextByte();
        byte fullCourses = (byte) (persons / capacity);
        byte personsLeft = (byte) (persons - fullCourses * capacity);
        if (personsLeft==0){
            System.out.println(fullCourses);
        } else {
            System.out.println(fullCourses+1);
        }
    }
}
