package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P01integerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());
        int thirdNumber = Integer.parseInt(scan.nextLine());
        int fourthNumber = Integer.parseInt(scan.nextLine());

        int sum = firstNumber + secondNumber;
        int division = sum / thirdNumber;
        int multiplication = division * fourthNumber;
        System.out.println(multiplication);
    }
}
