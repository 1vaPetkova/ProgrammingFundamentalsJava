package T01basicSyntax.lab;

import java.util.Scanner;

public class P03passedOrFailedv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double grade = Double.parseDouble(scan.nextLine());

        String result = (grade >=3)?"Passed!":"Failed!";
        System.out.println(result);
    }
}
