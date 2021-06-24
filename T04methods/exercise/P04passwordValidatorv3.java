package T04methods.exercise;

import java.util.Scanner;

public class P04passwordValidatorv3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        validators(input);
    }

    private static void validators(String input) {
        String output = "";
        if (checkNumberOfCharacters(input)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (checkIfOnlyDigitsAndNumbers(input)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (checkMinimumDigits(input)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (!checkNumberOfCharacters(input) && !checkIfOnlyDigitsAndNumbers(input) && !checkMinimumDigits(input)) {
            System.out.println("Password is valid");
        }
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

