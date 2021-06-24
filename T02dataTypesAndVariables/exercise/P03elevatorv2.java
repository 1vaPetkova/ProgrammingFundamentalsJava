package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P03elevatorv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte persons = scan.nextByte();
        byte capacity = scan.nextByte();
        double courses = Math.ceil(1.0*persons/capacity);
        System.out.printf("%.0f",courses);
    }
}
