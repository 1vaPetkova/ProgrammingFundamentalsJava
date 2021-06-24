package T04methods.exercise;

import java.util.Scanner;

public class P04passwordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String output = validators(input);
        System.out.println(output);
    }


    private static String validators(String input) {
        boolean charNumsValidator = false;
        boolean digitsTypeValidator = false;
        boolean minimumDigitsValidator = false;
        String output = "";
        if (checkNumberOfCharacters(input, charNumsValidator)) {
            output += "Password must be between 6 and 10 characters\n";
        }
        if (checkIfOnlyDigitsAndNumbers(input, digitsTypeValidator)) {
            output += "Password must consist only of letters and digits\n";
        }
        if (checkMinimumDigits(input, minimumDigitsValidator)) {
            output += "Password must have at least 2 digits\n";
        }
        if (output.equals("")){
            output = "Password is valid";
        }
        return output;
    }

    private static boolean checkNumberOfCharacters(String input, boolean charNumsValidator) {
        charNumsValidator = false;
        if (input.length() < 6 || input.length() > 10) {
            charNumsValidator = true;
        }
        return charNumsValidator;
    }

    private static boolean checkIfOnlyDigitsAndNumbers(String input, boolean digitsTypeValidator) {
        digitsTypeValidator = false;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if ((symbol < 'a' || symbol > 'z') && (symbol < 'A' || symbol > 'Z') && (symbol < '0' || symbol > '9')) {
                digitsTypeValidator = true;
                break;
            }
        }
        return digitsTypeValidator;
    }

    private static boolean checkMinimumDigits(String input, boolean minimumDigitsValidator) {
        minimumDigitsValidator = false;
        int countDigits = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if ((symbol >= '0' && symbol <= '9')){
                countDigits++;
            }
        }
        if (countDigits < 2) {
            minimumDigitsValidator = true;
        }
        return minimumDigitsValidator;
    }
}

