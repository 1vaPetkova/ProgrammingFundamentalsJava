package T01basicSyntax.lab;

import java.util.Scanner;

public class P01studentInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        double grade = Double.parseDouble(scan.nextLine());
        String result = String.format("Name: %s, Age: %d, Grade: %.2f", name, age, grade);
        System.out.print(result);
    }
}
