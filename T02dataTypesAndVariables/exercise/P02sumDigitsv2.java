package T02dataTypesAndVariables.exercise;

import java.util.Scanner;

public class P02sumDigitsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        int sumDigits = 0;
        for (int i = 0; i < number.length(); i++) {
            char symbol = number.charAt(i);
            if (symbol>='0'&&symbol<='9'){
                int digit = symbol-'0';
                sumDigits+=digit;
            }
        }
        System.out.println(sumDigits);
    }
}
