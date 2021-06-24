package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P05concatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.nextLine();
        String secondName = scan.nextLine();
        String delimiter = scan.nextLine();
        System.out.println(firstName + delimiter + secondName);
    }
}
