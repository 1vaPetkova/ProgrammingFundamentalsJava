package T04methods.lab;

import java.util.Scanner;

public class P07repeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int repeatCount = Integer.parseInt(scan.nextLine());

        String result = repeatString(input, repeatCount);
        System.out.println(result);
    }

    private static String repeatString(String input, int repeatCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            result.append(input);
        }
        return result.toString();
    }
}
