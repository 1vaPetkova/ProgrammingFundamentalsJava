package T02dataTypesAndVariables.lab;

import java.util.Scanner;

public class P07reversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.next().charAt(0);
        char secondChar = scan.next().charAt(0);
        char thirdChar = scan.next().charAt(0);

        System.out.printf("%c %c %c", thirdChar,secondChar,firstChar);
    }
}
