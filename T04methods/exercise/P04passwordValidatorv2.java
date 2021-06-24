package T04methods.exercise;

import java.util.Scanner;

public class P04passwordValidatorv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(validators(input));
    }


    private static String validators(String input) {
        String output = "";
        if (checkNumberOfCharacters(input)) {
            output += "Password must be between 6 and 10 characters\n";
        }
        if (checkIfOnlyDigitsAndNumbers(input)) {
            output += "Password must consist only of letters and digits\n";
        }
        if (checkMinimumDigits(input)) {
            output += "Password must have at least 2 digits\n";
        }
        if (output.equals("")) {
            output = "Password is valid";
        }
        return output;
    }

    private static boolean checkNumberOfCharacters(String input) {
        return input.length() < 6 || input.length() > 10;
    }

    private static boolean checkIfOnlyDigitsAndNumbers(String input) {
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if ((symbol < 'a' || symbol > 'z') && (symbol < 'A' || symbol > 'Z') && (symbol < '0' || symbol > '9')) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkMinimumDigits(String input) {
        int countDigits = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if ((symbol >= '0' && symbol <= '9')) {
                countDigits++;
            }
        }
        if (countDigits < 2) {
            return true;
        }
        return false;
    }
}

