package T02dataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class P01dataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String type = "";
        while (!input.equals("END")) {
            boolean isInteger = true;
            boolean isFloatingPoint = true;
            try {
                int integerValue = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                isInteger = false;
            }
            try {
                double doubleValue = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                isFloatingPoint = false;
            }
            if (isInteger) {
                type = "integer";
            } else if (isFloatingPoint) {
                type = "floating point";
            } else if (input.length() == 1) {
                type = "character";
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                type = "boolean";
            } else {
                type = "string";
            }
            System.out.printf("%s is %s type\n", input, type);
            input = scan.nextLine();
        }
    }
}




