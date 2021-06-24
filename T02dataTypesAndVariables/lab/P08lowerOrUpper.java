package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P08lowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char input = scan.nextLine().charAt(0);
        if (input>='A'&&input<='Z'){
            System.out.println("upper-case");
        } else if (input>='a'&&input<='z'){
            System.out.println("lower-case");
        }
    }
}
