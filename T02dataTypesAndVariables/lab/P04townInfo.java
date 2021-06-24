package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P04townInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int population = Integer.parseInt(scan.nextLine());
        double area = Double.parseDouble(scan.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.",name, population,(int) area);
    }
}
